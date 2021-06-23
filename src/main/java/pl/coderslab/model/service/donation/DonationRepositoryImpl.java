package pl.coderslab.model.service.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entity.Donation;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
class DonationRepositoryImpl implements DonationService{
    private final DonationRepository donationRepository;
    @Override
    public List<Donation> getDonation() {
        return donationRepository.findAll();
    }

    @Override
    public void createDonation(final Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Optional<Donation> getDonationByID(final double id) {
        return this.donationRepository.findById(id);
    }

    @Override
    public void updateDonation(final Donation donation) {
        if(donationRepository.findById(donation.getId()).isPresent()){
            donationRepository.save(donation);
        }
    }

    @Override
    public void deleteDonationByID(final double id) {
        donationRepository.deleteById(id);
    }
}
