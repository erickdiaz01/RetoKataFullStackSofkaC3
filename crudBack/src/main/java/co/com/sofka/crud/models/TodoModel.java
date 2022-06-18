package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Modelo de datos para la entidad de Todo, este modelo tiene los atributos
 * del ID autogenerado por JPA, nombre de la tarea a realizar, un estado que
 * corresponde a si se ha completado la tarea o no, tiene indexado un atributo
 * correspondiente a la lista de tareas a la cual pertenece dicha tarea, esta
 * lista de tareas solo puede tener esta lista de tareas, pero esa lista de
 * tareas puede tener muchas mas tareas a completar.
 * 
 * Esta entidad esta manejada por JPA, en SQL la tabla con el nombre de Todos
 * Tambien contiene los Getters y Setter de los atributos
 *
 * @author Erick Diaz
 * @date 17-06-2022
 * 
 */
@Entity
@Table(name = "Todos")
public class TodoModel {

    @Id
    @GeneratedValue
    private Long id_todo;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "isCompleted", nullable = false)
    private boolean isCompleted;
    @JsonBackReference
    @ManyToOne(optional = true, cascade = { CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "listTodo", nullable = true)
    private TodoListModel listTodo;

    public Long getId_todo() {
        return id_todo;
    }

    public void setId_todo(Long id_todo) {
        this.id_todo = id_todo;
    }

    public TodoListModel getListTodo() {
        return listTodo;
    }

    public void setListTodo(TodoListModel listTodo) {
        this.listTodo = listTodo;
    }

    public Long getId() {
        return id_todo;
    }

    public void setId(Long id) {
        this.id_todo = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }
}
