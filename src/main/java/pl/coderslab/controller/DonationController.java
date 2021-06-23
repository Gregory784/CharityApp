package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.entity.Donation;
import pl.coderslab.model.service.category.CategoryService;
import pl.coderslab.model.service.donation.DonationService;
import pl.coderslab.model.service.institution.InstitutionService;

@Controller
@AllArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/adddonation")
    public String addDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("institutions", institutionService.getInstitutions());
        return "form";
    }

}
