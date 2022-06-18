package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Modelo de datos para la entidad de Categoria, este modelo tiene los atributos
 * del ID autogenerado por JPA, nombre de la categoria, una lista que esta
 * relacionada bidireccionalmente con el modelo de datos de las listas de tareas
 * TodoList siendo esta entidad perteneciente a varios objetos de la entidad TodoList.
 * 
 * Esta entidad esta manejada por JPA, en SQL la tabla con el nombre de Categories
 * 
 *
 * @author Erick Diaz
 * @date 17-06-2022
 * Tambien contiene los Getters y Setter de los atributos
 */
@Entity
@Table(name = "Categories")
public class CategoryModel {
    @Id
    @GeneratedValue
    private Long id_category;

    @Column(name = "name")
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<TodoListModel> listsTodos;

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoListModel> getListsTodos() {
        return listsTodos;
    }

    public void setListsTodos(List<TodoListModel> listsTodos) {
        this.listsTodos = listsTodos;
    }

}
