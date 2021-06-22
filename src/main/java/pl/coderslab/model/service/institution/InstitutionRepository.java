package pl.coderslab.model.service.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entity.Institution;

interface InstitutionRepository extends JpaRepository<Institution, Double> {
}
