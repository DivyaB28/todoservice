package com.practice.todo.controllers;

import com.practice.todo.models.Todolist;
import com.practice.todo.repositories.TodolistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todolist")
public class TodolistController {
    @Autowired
    private TodolistRepository todolistRepository;

    @GetMapping
    public List<Todolist> list(){
        return todolistRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Todolist get(@PathVariable Long id) {
        return todolistRepository.getById(id);
    }

    @PostMapping
    public Todolist create(@RequestBody final Todolist todolist){
        return todolistRepository.saveAndFlush(todolist);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        todolistRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Todolist update(@PathVariable Long id, @RequestBody Todolist todolist){
        //TODO: ADD validation that all attributes are passed in otherwise return 400 bad response
        Todolist existingTodolist =todolistRepository.getById(id);
        BeanUtils.copyProperties(todolist, existingTodolist, "todo_id");
        return todolistRepository.saveAndFlush(existingTodolist);
    }
}
