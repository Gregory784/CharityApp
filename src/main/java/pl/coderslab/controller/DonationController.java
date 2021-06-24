package pl.coderslab.controller;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.entity.Category;
import pl.coderslab.model.entity.Donation;
import pl.coderslab.model.entity.Institution;
import pl.coderslab.model.service.category.CategoryService;
import pl.coderslab.model.service.donation.DonationService;
import pl.coderslab.model.service.institution.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/adddonation")
    public String addDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/adddonation")
    public String addDonationFormPost(BindingResult bindingResult, Model model, @Valid Donation donation){
        if(bindingResult.hasErrors()){
            return "form";
        }
        if(donation.getQuantity() <= 0){
            bindingResult.addError(new ObjectError("Quantity", "Quantity cannot be less or equal 0"));
            return "form";
        }
        donationService.createDonation(donation);
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.getCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.getInstitutions();
    }
}
