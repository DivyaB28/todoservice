package com.practice.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    private Long user_id;
    private String user_name;
    private String password;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Todolist> todolists;

    public List<Todolist> getTodolists() {
        return todolists;
    }

    public void setTodolists(List<Todolist> todolists) {
        this.todolists = todolists;
    }

    public User(){}

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
