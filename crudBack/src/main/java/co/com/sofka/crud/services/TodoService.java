package co.com.sofka.crud.services;

import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repositoryTodo;

    public Iterable<TodoModel> listTodo(){
        return repositoryTodo.findAll();
    }

    public TodoModel saveTodo(TodoModel newTodo){
        return repositoryTodo.save(newTodo);
    }

    public void deleteTodo (Long id){
        repositoryTodo.delete(getById(id));
    }

    public TodoModel getById (Long id){
        return repositoryTodo.findById(id).orElseThrow();
    }
}
