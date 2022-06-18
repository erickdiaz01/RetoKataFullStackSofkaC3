package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.CategoryModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que modelara internamente los metodos correspondientes a un CRUD para la entidad de Category,
 * por ello extiende de la interfaz de CrudRepository de Spring Boot
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
}
