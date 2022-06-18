package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Modelo de datos para la entidad de TodoList, este modelo tiene los atributos
 * del ID autogenerado por JPA, nombre de la lista de tareas, una categoria
 * indexada, la cual es unica para la lista de tareas, pero puede estar en
 * varias lista de tareas. Tiene un atributo que esta relacionado
 * bidireccionalmente con la entidad de Todo, es decir, tiene una lista de
 * tareas (Por ello el nombre de esta entidad)
 * 
 * Esta entidad esta manejada por JPA, en SQL la tabla con el nombre de
 * TodoLists
 * Tambien contiene los Getters y Setter de los atributos
 *
 * @author Erick Diaz
 * @date 17-06-2022
 * 
 */
@Entity
@Table(name = "TodoLists")
public class TodoListModel {
    @Id
    @GeneratedValue
    private Long id_TodoList;

    @Column(name = "nameTodoList", nullable = false, length = 50)
    private String name;
    @JsonBackReference
    @ManyToOne(optional = false, cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "category", nullable = true)
    private CategoryModel category;

    @JsonManagedReference
    @OneToMany(mappedBy = "listTodo")
    private List<TodoModel> listTodos;

    public Long getId_TodoList() {
        return id_TodoList;
    }

    public void setId_TodoList(Long id_TodoList) {
        this.id_TodoList = id_TodoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public List<TodoModel> getListTodos() {
        return listTodos;
    }

    public void setListTodos(List<TodoModel> listTodos) {
        this.listTodos = listTodos;
    }
}
