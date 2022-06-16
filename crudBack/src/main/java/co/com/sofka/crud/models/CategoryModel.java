package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

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
