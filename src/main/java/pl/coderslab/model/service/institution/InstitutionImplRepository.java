package pl.coderslab.model.service.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entity.Institution;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
class InstitutionImplRepository implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public void createInstitution(final Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public Optional<Institution> getInstitutionByID(final long id) {
        return this.institutionRepository.findById(id);
    }

    @Override
    public void updateInstitution(final Institution institution) {
        if(institutionRepository.findById(institution.getId()).isPresent()){
            institutionRepository.save(institution);
        }
    }

    @Override
    public void deleteInstitutionByID(final long id) {
        institutionRepository.deleteById(id);
    }
}
