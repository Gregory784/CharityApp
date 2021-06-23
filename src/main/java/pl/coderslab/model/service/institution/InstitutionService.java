package pl.coderslab.model.service.institution;

import pl.coderslab.model.entity.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    List<Institution> getInstitutions();

    void createInstitution(Institution institution);

    Optional<Institution> getInstitutionByID(double id);

    void updateInstitution(Institution institution);

    void deleteInstitutionByID(double id);

}
