package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.TodoModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que modelara internamente los metodos correspondientes a un CRUD de
 * la entidad Todo,
 * por ello extiende de la interfaz de CrudRepository de Spring Boot.
 * Adicionalmente se agrego un metodo personalizado el cual es el de encontrar
 * todas las tareas por el nombre de la lista de tareas en las cuales estan
 * alojadas en dicha lista
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
public interface TodoRepository extends CrudRepository<TodoModel, Long> {
    public Iterable<TodoModel> findAllByListTodo_Name(String name);

}
