package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.entity.User;
import pl.coderslab.model.service.SecurityService;
import pl.coderslab.model.service.role.RoleRepository;
import pl.coderslab.model.service.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final SecurityService securityService;
    private final RoleRepository roleRepository;

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
        u.setPassword(userDto.getPassword());
        u.addRole(roleRepository.getOne(2L));

        userService.createUser(u);
        securityService.autoLogin(u.getEmail(), u.getPassword());
            return "redirect:/user";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/admin") //TODO - admin panel CRUD Category, Institution, Role etc.
    @ResponseBody
    public String adminpanel(Authentication authentication, Model model){

        return "<h2> Tu jest panel admina </h2>" ;
    }

}
