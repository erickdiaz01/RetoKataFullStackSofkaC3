package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase corresponde a un controlador del modelo de datos Todo, se encarga
 * de generar los endpoints
 * de las peticiones y mediante el servicio del modelo de ejecutar el metodo
 * correspondiente a cada peticion
 * Para evitar los problemas de CORS se adiciona una gestion del origen de las
 * peticiones al localhost con el puerto 5500 el cual corresponde al utilizado
 * por el servidor de Live Server extension de Visual Studio Code
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
@RestController
public class TodoController {
    @Autowired
    private TodoService serviceTodo;

    /**
     * Metodo con la peticion GET, recoge todas las listas de tareas disponibles con
     * sus 'listas' de tareas.
     * 
     * @return {CategoryModel} Lista de objetos de la entidad TodoList
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todos")
    public Iterable<TodoModel> listTodo() {
        return serviceTodo.listTodo();
    }

    /**
     * Metodo con la peticion GET, este metodo especifico hace que se pase el
     * parametro del nombre de la lista de tareas con ese nombre especifico, el
     * nombre se pasa mediante el parametro proveniente del Endpoint
     * 
     * @param name
     * @return {TodoModel}
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todos/{nameList}")
    public Iterable<TodoModel> listTodoEspecificByNameList(@PathVariable("nameList") String name) {
        return serviceTodo.listTodoEspecificByNameList(name);
    }

    /**
     * /**
     * Metodo con la peticion POST, del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase Todo y lo envia en una peticion al
     * endpoint para guardarlo en la base de datos correspondiente
     * 
     * 
     * @param newTodo
     * @return {TodoModel} devulve el objeto creado por el metodo y tal como se
     *         guardo en la base de datos
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping(value = "/api/todo")
    public TodoModel saveTodo(@RequestBody TodoModel newTodo) {
        return serviceTodo.saveTodo(newTodo);
    }

    /**
     * Metodo con la peticion PUT, del cuerpo de la peticion recoge los datos de un
     * objeto de la clase Todo previamente creado, esto significa que el cuerpo
     * debe contener ya un id unico para que al mandar la peticion se actualice el
     * objeto especifico y que no se cree uno nuevo en si. En el endPoint tambien se
     * manda el ID del objeto a actualizar para no crear uno nuevo, o no cambiar el
     * ID correspondiente
     * 
     * @param actuallyTodo
     * @return {TodoModel} devuelve el objeto actualizado tal cual se guardo en
     *         la base de datos
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping(value = "/api/todo/{id}")
    public TodoModel updateTodo(@RequestBody TodoModel actuallyTodo) {

        return serviceTodo.saveTodo(actuallyTodo);

    }

    /**
     * * Metodo con la peticion DELETE, solamente es necesario pasar por el EndPoint
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada, el parametro se saca del EndPoint
     * 
     * @param id
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping(value = "/api/todo/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        serviceTodo.deleteTodo(id);
    }

    /**
     * Metodo con la peticion GET, el metodo busca y devuelve un objeto de la clase
     * Todo, este objeto se busca con el parametro del ID unico, por lo que se
     * pasa desde el Endpoint el parametro del ID a buscar
     * 
     * @param id
     * @return {TodoModel}
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todo/{id}")
    public TodoModel getById(@PathVariable Long id) {
        return serviceTodo.getById(id);
    }
}
