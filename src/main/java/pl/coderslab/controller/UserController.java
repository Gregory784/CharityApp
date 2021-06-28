package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.entity.User;
import pl.coderslab.model.service.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/adduser")
    public String addUserGet(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/adduser")
    public String addUserPost(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        //conditions
        if (!user.getPassword().equals(user.getPassword2())) {
            bindingResult.rejectValue("password2", "error.user", "Password are different");
            bindingResult.rejectValue("password", "error.user", "Password are different");
            user.setPassword("");
            user.setPassword2("");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }
            userService.createUser(user);
            return "index";
    }
}
