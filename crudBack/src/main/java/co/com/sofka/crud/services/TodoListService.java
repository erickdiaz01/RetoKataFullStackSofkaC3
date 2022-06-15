package co.com.sofka.crud.services;

import co.com.sofka.crud.models.TodoListModel;
import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository repositoryTodoList;

    public Iterable<TodoListModel> listTodoList(){
        return repositoryTodoList.findAll();
    }

    public TodoListModel saveTodoList(TodoListModel newTodoList){
        return repositoryTodoList.save(newTodoList);
    }

    public void deleteTodoList (Long id){
        repositoryTodoList.delete(getById(id));
    }

    public TodoListModel getById (Long id){
        return repositoryTodoList.findById(id).orElseThrow();
    }

}
