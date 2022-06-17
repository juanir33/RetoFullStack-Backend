package com.sofka.todolist.todolist.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "subtarea")

public class Subtarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    private Long id;

    @Column(name = "sub_titulo",  nullable = false,  length = 45)
    private String nombre;

    @Column(name = "sub_is_done", nullable = false)
    private Boolean subdone = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarea_id", nullable = false)
    @JsonBackReference
    private Tarea tarea;


}


