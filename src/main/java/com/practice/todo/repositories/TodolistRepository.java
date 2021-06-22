package com.practice.todo.repositories;

import com.practice.todo.models.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist, Long> {
}
