package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.CategoryModel;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<CategoryModel,Long> {
}
