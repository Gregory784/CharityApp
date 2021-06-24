package pl.coderslab.model.service.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
