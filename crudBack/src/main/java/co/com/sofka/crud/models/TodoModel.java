package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Todos")
public class TodoModel {

    @Id
    @GeneratedValue
    private Long id_todo;

    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name="isCompleted",nullable = false)
    private boolean isCompleted;
   @JsonBackReference
   @ManyToOne(optional = true,cascade = {CascadeType.MERGE
           //,CascadeType.REMOVE
   },fetch = FetchType.LAZY)
   @JoinColumn(name = "listTodo",nullable = true)
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
