package pl.coderslab.model.service.category;

import pl.coderslab.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    void createCategory(Category category);

    Optional<Category> getCategoryByID(long id);

    void updateCategory(Category category);

    void deleteCategoryByID(long id);

}
