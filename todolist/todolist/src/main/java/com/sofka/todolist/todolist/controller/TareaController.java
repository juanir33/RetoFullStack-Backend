package com.sofka.todolist.todolist.controller;

import com.sofka.todolist.todolist.domain.Tarea;
import com.sofka.todolist.todolist.service.TareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping ("api/tarea")
public class TareaController {
    @Autowired
    TareaService tareaService;


    @GetMapping()
    public ArrayList<Tarea> obtenerTodosLasTareas(){return  tareaService.obtenerTodasLasTareas();}


    @PostMapping()
    public Tarea crearNuevaTarea(@RequestBody Tarea tarea){return tareaService.crearTarea(tarea);}



    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.tareaService.eliminarTarea(id);
        if (ok) {
            return "Se eliminó la tarea" ;
        } else {
            return "No se pudo eliminar la tarea";
        }
    }
}

