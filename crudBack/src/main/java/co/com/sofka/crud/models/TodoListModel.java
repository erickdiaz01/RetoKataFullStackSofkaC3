package co.com.sofka.crud.models;

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

    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private CategoryModel category;

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
