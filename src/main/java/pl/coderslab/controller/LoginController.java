package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.service.user.UserService;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class LoginController {
    private final UserService userService;
    @GetMapping({""})
    public String authorizedWelocme (Authentication authentication, Model model){
        model.addAttribute("user", userService.findByEmail(authentication.getName()));
        return "user/index";
    }


}
