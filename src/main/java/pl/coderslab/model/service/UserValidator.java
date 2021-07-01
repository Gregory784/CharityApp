package pl.coderslab.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.coderslab.model.entity.User;
import pl.coderslab.model.service.user.UserService;


@Component
@AllArgsConstructor
public class UserValidator implements Validator {
    private final UserService userService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","NotEmpty");
        if (user.getEmail().length() < 5 || user.getEmail().length() > 32){
            errors.rejectValue("email","Size.userForm.email");
        }
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 7 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }


    }
}
