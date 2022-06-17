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

    /**
     * Metodo para el pedido de listar las tareas
     * @return Array de todas las listas de tareas existentes.
     */
    @GetMapping()
    public ArrayList<Tarea> obtenerTodosLasTareas(){return  tareaService.obtenerTodasLasTareas();}

    /**
     * Metodo para crear una nueva lista de tareas
     * @param tarea
     */

    @PostMapping()
    public Tarea crearNuevaTarea(@RequestBody Tarea tarea){return tareaService.crearTarea(tarea);}

    /**
     * Metodo para eliminar una lista de tareas por su id
     * @param id id de la subtarea, como parametro en la url.
     *
     */

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.tareaService.eliminarTarea(id);
        if (ok) {
            return "Se eliminó la tarea" ;
        } else {
            return "No se pudo eliminar la tarea";
        }
    }
    @PutMapping(path = "/{id}")
    public Tarea actualizarTarea(@PathVariable("id") Long id, @RequestBody Tarea tarea) {

        return   tareaService.actualizarTarea(id, tarea);

    }
}

