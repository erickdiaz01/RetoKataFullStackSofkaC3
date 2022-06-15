package co.com.sofka.crud.models;

import javax.persistence.*;

@Entity
@Table(name = "Todos")
public class TodoModel {

    @Id
    @GeneratedValue
    private Long id_todo;

    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name="isCompleted")
    private boolean isCompleted;

   @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name = "listOfTodo")
    private TodoListModel listTodo;

   @Column(name = "description", length = 100)
   private String description;

    public TodoModel() {
        this.isCompleted = false;
    }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
