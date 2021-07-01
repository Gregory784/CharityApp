package pl.coderslab.controller;

import lombok.AllArgsConstructor;
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
    public String authorizedWelocme (Model model){
        return "user/index";
    }
}
