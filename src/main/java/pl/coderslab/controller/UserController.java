package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.entity.User;
import pl.coderslab.model.service.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/adduser")
    public String addUserGet(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/adduser")
    public String addUserPost(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult, Model model) {
        //conditions
        boolean isNewUser = userService.existsByEmail(userDto.getEmail());
        if (!userDto.getPassword().equals(userDto.getPassword2())) {
            bindingResult.rejectValue("password", "error.user","Password are different");
            bindingResult.rejectValue("password2", "error.user", "Password are different");
            userDto.setPassword("");
            userDto.setPassword2("");
        }
        if(isNewUser){
            bindingResult.rejectValue("email", "error.user", "User with this email is already exist");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User u = new User();
        u.setName(userDto.getName());
        u.setLastName(userDto.getLastName());
        u.setEmail(userDto.getEmail());
        u.setPassword(hashPassword(userDto.getPassword()));

        userService.createUser(u);
            return "redirect:";
    }
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
