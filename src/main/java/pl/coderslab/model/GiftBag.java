package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import pl.coderslab.model.entity.Donation;
import pl.coderslab.model.service.donation.DonationService;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class GiftBag {
    private final DonationService donationService;

    public int donatedBags() {
        return donationService.getDonation().stream()
                .filter(donation -> donation.getPickUpDate().isBefore(LocalDate.now()))
                .map(Donation::getQuantity)
                .reduce(0, Integer::sum);
    }

    public int donatedGifts() {
        long countGifts = donationService.getDonation().stream()
                .filter(donation -> donation.getPickUpDate().isBefore(LocalDate.now()))
                //  .map(Donation::getQuantity)
                .count();
        return Math.toIntExact(countGifts);
    }
}
