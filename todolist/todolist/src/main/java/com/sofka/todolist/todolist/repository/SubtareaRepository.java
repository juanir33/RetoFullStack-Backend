package com.sofka.todolist.todolist.repository;

import com.sofka.todolist.todolist.domain.Subtarea;
import org.springframework.data.repository.CrudRepository;

public interface SubtareaRepository extends CrudRepository<Subtarea, Long> {
}