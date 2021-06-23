package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.service.institution.InstitutionService;


@Controller
@AllArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "index";
    }
}
