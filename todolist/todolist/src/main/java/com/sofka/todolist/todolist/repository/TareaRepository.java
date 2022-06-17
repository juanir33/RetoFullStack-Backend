package com.sofka.todolist.todolist.repository;

import com.sofka.todolist.todolist.domain.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
}