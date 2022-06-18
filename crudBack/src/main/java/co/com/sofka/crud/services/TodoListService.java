package co.com.sofka.crud.services;

import co.com.sofka.crud.models.TodoListModel;
import co.com.sofka.crud.repositories.TodoListRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio que utiliza los metodos manejados por el repositorio especifico de
 * la entidad TodoList
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
@Service
public class TodoListService {
    @Autowired
    private TodoListRepository repositoryTodoList;
    @Autowired
    private TodoRepository repositoryTodo;

    /**
     * Este metodo recoge todas las listas de tareas
     * guardadas en la base de datos y las devuelve en una lista
     * 
     * @return {TodoListModel}
     */
    public Iterable<TodoListModel> listTodoList() {
        return repositoryTodoList.findAll();
    }

    /**
     * 
     * Del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase TodoList y lo envia en una peticion al
     * metodo para guardarlo en la base de datos correspondiente
     * 
     * 
     * @param newTodoList
     * @return {TodoListModel} devuelve el objeto tal cual se guarda en la base de
     *         datos
     */
    public TodoListModel saveTodoList(TodoListModel newTodoList) {
        return repositoryTodoList.save(newTodoList);
    }

    /**
     * Solamente es necesario pasar
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada
     * 
     * @param id
     */
    public void deleteTodoList(Long id) {
        TodoListModel list = getById(id);
        list.getListTodos().forEach(todo -> {
            repositoryTodo.delete(todo);
        });
        repositoryTodoList.delete(getById(id));
    }

    /**
     * El metodo busca y devuelve un objeto de la clase
     * TodoLis, este objeto se busca con el parametro del ID unico
     * 
     * @param id
     * @return {TodoListModel} devuelve el objeto encontrado por el ID
     */
    public TodoListModel getById(Long id) {
        return repositoryTodoList.findById(id).orElseThrow();
    }

}
