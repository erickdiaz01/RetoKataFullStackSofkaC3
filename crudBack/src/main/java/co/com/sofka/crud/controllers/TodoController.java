package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
@Autowired
private TodoService serviceTodo;
@GetMapping(value = "/api/todos")
    public Iterable<TodoModel> listTodo(){
        return serviceTodo.listTodo();
    }
@PostMapping(value = "/api/todo")
    public TodoModel saveTodo(@RequestBody TodoModel newTodo){
        return serviceTodo.saveTodo(newTodo);
    }
    @PutMapping(value = "/api/todo/{id}")
    public TodoModel updateTodo(@RequestBody TodoModel actuallyTodo){

        if(actuallyTodo.getId()!= null) {
            return serviceTodo.saveTodo(actuallyTodo);
        }
        throw new RuntimeException("Para actualizar una tarea es necesario ingresar el ID en el cuerpo de la peticion");

    }
@DeleteMapping(value = "/api/todo/{id}")
    public void deleteTodo (@PathVariable("id") Long id){
        serviceTodo.deleteTodo(id);
    }
@GetMapping(value = "/api/todo/{id}")
    public TodoModel getById (@PathVariable Long id){
        return serviceTodo.getById(id);
    }
}
