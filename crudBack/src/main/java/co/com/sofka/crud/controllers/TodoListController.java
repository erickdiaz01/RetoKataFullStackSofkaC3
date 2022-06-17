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
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todolist")
    public Iterable<TodoListModel> listTodoList(){
        return serviceTodoList.listTodoList();
    }
    @PostMapping(value = "/api/todolist")
    public TodoListModel saveTodoList(@RequestBody TodoListModel newTodoList){
        return serviceTodoList.saveTodoList(newTodoList);
    }
    @PutMapping(value = "/api/todolist/{id}")
    public TodoListModel updateTodoList(@RequestBody TodoListModel actuallyTodoList){
    if(actuallyTodoList.getId_TodoList()!=null){
        return serviceTodoList.saveTodoList(actuallyTodoList);
    }
        throw new RuntimeException("Para actualizar una lista de tareas es necesario ingresar el ID en el cuerpo de la peticion");
    }

    @DeleteMapping(value = "/api/todolist/{id}")
    public void deleteTodoList (@PathVariable("id") Long id){
        serviceTodoList.deleteTodoList(id);
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todolist/{id}")
    public TodoListModel getById (@PathVariable("id") Long id){
        return serviceTodoList.getById(id);
    }

}
