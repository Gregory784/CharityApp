package pl.coderslab.model.service.category;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entity.Category;

interface CategoryRepository extends JpaRepository<Category, Long> {
}
