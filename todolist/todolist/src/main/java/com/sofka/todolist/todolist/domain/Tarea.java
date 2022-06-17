package com.sofka.todolist.todolist.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @OneToMany(fetch = FetchType.EAGER,
            targetEntity = Subtarea.class,
            cascade = CascadeType.REMOVE,mappedBy = "tarea")
    @JsonManagedReference
    private List<Subtarea> subtareas = new ArrayList<>();}

