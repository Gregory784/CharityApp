package pl.coderslab.model.service.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entity.Category;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class JpaCategoryRepository implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(final Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryByID(final double id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public void updateCategory(final Category category) {
        if(categoryRepository.findById(category.getId()).isPresent()){
            categoryRepository.save(category);
        }
    }

    @Override
    public void deleteCategoryByID(final double id) {
        categoryRepository.deleteById(id);
    }
}
