package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.TodoListModel;
import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase corresponde a un controlador del modelo de datos TodoList, se
 * encarga de generar los endpoints
 * de las peticiones y mediante el servicio del modelo de ejecutar el metodo
 * correspondiente a cada peticion
 * 
 * Para evitar los problemas de CORS se adiciona una gestion del origen de las
 * peticiones al localhost con el puerto 5500 el cual corresponde al utilizado
 * por el servidor de Live Server extension de Visual Studio Code
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
@RestController
public class TodoListController {

    @Autowired
    private TodoListService serviceTodoList;

    /**
     * Metodo con la peticion GET, este metodo recoge todas las listas de tareas
     * guardadas en la base de datos y las devuelve en una lista
     * 
     * @return {TodoListModel}
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todolist")
    public Iterable<TodoListModel> listTodoList() {
        return serviceTodoList.listTodoList();
    }

    /**
     * 
     * Metodo con la peticion POST, del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase TodoList y lo envia en una peticion al
     * endpoint para guardarlo en la base de datos correspondiente
     * 
     * 
     * @param newTodoList
     * @return {TodoListModel} devuelve el objeto tal cual se guarda en la base de
     *         datos
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping(value = "/api/todolist")
    public TodoListModel saveTodoList(@RequestBody TodoListModel newTodoList) {
        return serviceTodoList.saveTodoList(newTodoList);
    }

    /**
     * Metodo con la peticion PUT, del cuerpo de la peticion recoge los datos de un
     * objeto de la clase TodoList previamente creado, esto significa que el cuerpo
     * debe contener ya un id unico para que al mandar la peticion se actualice el
     * objeto especifico y que no se cree uno nuevo en si. En el endPoint tambien se
     * manda el ID del objeto a actualizar para no crear uno nuevo, o no cambiar el
     * ID correspondiente
     * 
     * @param actuallyTodoList
     * @return {TodoListModel} devuelve el objeto tal cual fue actualizado y
     *         guardado en la base de datos
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping(value = "/api/todolist/{id}")
    public TodoListModel updateTodoList(@RequestBody TodoListModel actuallyTodoList) {
        if (actuallyTodoList.getId_TodoList() != null) {
            return serviceTodoList.saveTodoList(actuallyTodoList);
        }
        throw new RuntimeException(
                "Para actualizar una lista de tareas es necesario ingresar el ID en el cuerpo de la peticion");
    }

    /**
     * Metodo con la peticion DELETE, solamente es necesario pasar por el EndPoint
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada, el parametro se saca del EndPoint
     * 
     * @param id
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping(value = "/api/todolist/{id}")
    public void deleteTodoList(@PathVariable("id") Long id) {
        serviceTodoList.deleteTodoList(id);
    }

    /**
     * Metodo con la peticion GET, el metodo busca y devuelve un objeto de la clase
     * TodoLis, este objeto se busca con el parametro del ID unico, por lo que se
     * pasa desde el Endpoint el parametro del ID a buscar
     * 
     * @param id
     * @return {TodoListModel}
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/todolist/{id}")
    public TodoListModel getById(@PathVariable("id") Long id) {
        return serviceTodoList.getById(id);
    }

}
