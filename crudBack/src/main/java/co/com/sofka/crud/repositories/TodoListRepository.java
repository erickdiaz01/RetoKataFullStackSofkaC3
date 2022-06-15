package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.TodoListModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoListModel,Long> {
}
