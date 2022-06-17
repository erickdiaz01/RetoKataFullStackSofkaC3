package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
@Autowired
private TodoService serviceTodo;
    @CrossOrigin("http://127.0.0.1:5500")
@GetMapping(value = "/api/todos")
    public Iterable<TodoModel> listTodo(){
        return serviceTodo.listTodo();
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todos/{nameList}")
    public Iterable<TodoModel> listTodoEspecificByNameList(@PathVariable("nameList") String name){return serviceTodo.listTodoEspecificByNameList(name);}
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping(value = "/api/todo")
    public TodoModel saveTodo(@RequestBody TodoModel newTodo){
        return serviceTodo.saveTodo(newTodo);
    }
    @PutMapping(value = "/api/todo/{id}")
    public TodoModel updateTodo(@RequestBody TodoModel actuallyTodo){


            return serviceTodo.saveTodo(actuallyTodo);


    }
    @CrossOrigin("http://127.0.0.1:5500")
@DeleteMapping(value = "/api/todo/{id}")
    public void deleteTodo (@PathVariable("id") Long id){
        serviceTodo.deleteTodo(id);
    }
    @CrossOrigin("http://127.0.0.1:5500")
@GetMapping(value = "/api/todo/{id}")
    public TodoModel getById (@PathVariable Long id){
        return serviceTodo.getById(id);
    }
}
