package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TodoListModel;
import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoListController {

    @Autowired
    private TodoListService serviceTodoList;
@GetMapping(value = "/api/todolist")
    public Iterable<TodoListModel> listTodoList(){
        return serviceTodoList.listTodoList();
    }
@PostMapping(value = "/api/todolist")
    public TodoListModel saveTodoList(TodoListModel newTodoList){
        return serviceTodoList.saveTodoList(newTodoList);
    }

    @DeleteMapping(value = "/api/todolist/{id}")
    public void deleteTodoList (@PathVariable("id") Long id){
        serviceTodoList.deleteTodoList(id);
    }

    @GetMapping(value = "/api/todolist/{id}")
    public TodoListModel getById (@PathVariable("id") Long id){
        return serviceTodoList.getById(id);
    }

}
