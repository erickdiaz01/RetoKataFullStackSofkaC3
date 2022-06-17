package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TodoLists")
public class TodoListModel {
    @Id
    @GeneratedValue
    private Long id_TodoList;

    @Column(name = "nameTodoList",nullable = false,length = 50)
    private String name;
    @JsonBackReference
    @ManyToOne(optional = true,cascade = {CascadeType.MERGE
            //,CascadeType.REMOVE
    },fetch = FetchType.LAZY)
    @JoinColumn(name = "category",nullable = true)
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
