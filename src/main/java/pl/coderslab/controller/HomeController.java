package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.logic.GiftBag;
import pl.coderslab.model.service.institution.InstitutionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@AllArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final GiftBag giftBag;

    @RequestMapping({"/"})
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("donatedbags", giftBag.donatedBags());
        model.addAttribute("donatedgifts", giftBag.donatedGifts());
        return "index";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
