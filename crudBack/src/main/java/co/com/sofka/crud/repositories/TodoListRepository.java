package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.TodoListModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que modelara internamente los metodos correspondientes a un CRUD para la entidad de TodoList,
 * por ello extiende de la interfaz de CrudRepository de Spring Boot
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
public interface TodoListRepository extends CrudRepository<TodoListModel,Long> {
}
