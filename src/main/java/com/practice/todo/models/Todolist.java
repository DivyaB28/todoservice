package com.practice.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "todolist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;
    private String item_name;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;

@ManyToMany
@JoinTable(
        name = "users_todolist",
        joinColumns = @JoinColumn(name = "todo_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Todolist(){}

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
