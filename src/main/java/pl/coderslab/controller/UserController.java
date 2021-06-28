package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.entity.User;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/adduser")
    public String addUserGet(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/adduser")
    public String addUserPost(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        //conditions
        if(!user.getPassword().equals(user.getPassword2())){
            bindingResult.rejectValue("password2", "error.user", "Password are different");
        }
        return "login";
    }
}
