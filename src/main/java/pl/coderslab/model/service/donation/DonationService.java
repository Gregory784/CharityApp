package pl.coderslab.model.service.donation;

import pl.coderslab.model.entity.Donation;

import java.util.List;
import java.util.Optional;

public interface DonationService {
    List<Donation> getDonation();

    void createDonation(Donation donation);

    Optional<Donation> getDonationByID(long id);

    void updateDonation(Donation donation);

    void deleteDonationByID(long id);
}
