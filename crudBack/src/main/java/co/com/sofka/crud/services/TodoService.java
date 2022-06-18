package co.com.sofka.crud.services;

import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repositoryTodo;

    /**
     * Recoge todas las tareas disponibles con
     * sus 'listas' de tareas correspondiente.
     * 
     * @return {TodoModel} Lista de objetos de la entidad Todo
     */
    public Iterable<TodoModel> listTodo() {
        return repositoryTodo.findAll();
    }

    /**
     * Este metodo especifico hace que se pase el
     * parametro del nombre de la lista de tareas con ese nombre especifico
     * 
     * @param name
     * @return {TodoModel}
     */
    public Iterable<TodoModel> listTodoEspecificByNameList(String name) {
        return repositoryTodo.findAllByListTodo_Name(name);
    }

    /**
     * 
     * Del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase Todo y lo envia en una peticion al
     * metodo para guardarlo en la base de datos correspondiente
     * 
     * 
     * @param newTodo
     * @return {TodoModel} devulve el objeto creado por el metodo y tal como se
     *         guardo en la base de datos
     */
    public TodoModel saveTodo(TodoModel newTodo) {
        return repositoryTodo.save(newTodo);
    }

    /**
     * Solamente es necesario pasar
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada
     * 
     * @param id
     */
    public void deleteTodo(Long id) {
        repositoryTodo.delete(getById(id));
    }

    /**
     * El metodo busca y devuelve un objeto de la clase
     * Todo, este objeto se busca con el parametro del ID unico
     * 
     * @param id
     * @return {TodoModel} devuelve el objeto encontrado con dicho ID
     */
    public TodoModel getById(Long id) {
        return repositoryTodo.findById(id).orElseThrow();
    }
}
