package com.sofka.todolist.todolist.controller;

import com.sofka.todolist.todolist.domain.Subtarea;
import com.sofka.todolist.todolist.service.SubtareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author  Juan Ramallo
 * @version  1.0
 * Controlador para la entidad subtarea
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/subtarea")
public class SubtareaController {

    @Autowired
    private SubtareaService subtareaService;

    /**
     * Metodo para el pedido de listar las subtareas
     * @return Array de todas las subtareas existentes.
     */
    @GetMapping()
    public ArrayList<Subtarea> obtenerTodasSubtareas(){
        return (ArrayList<Subtarea>) subtareaService.obtenerTodasLasSubtareas();
    }

    /**
     * Metodo para crear una nueva subtarea dentro de una lista de tareas
     * @param subtarea
     * @return
     */

    @PostMapping()
    public Subtarea crearNuevaSubtarea(@RequestBody Subtarea subtarea){

        return subtareaService.crearSubtarea(subtarea);
    }

    /**
     * Metodo para poder eliminar una subtarea por su id.
     * @param id
     * @return regresa un mensaje para verificar si se pudo eliminar
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarUnaSubtarea(@PathVariable("id") Long id){
        boolean ok = subtareaService.eliminarUnaSubtarea(id);
        if (ok) {
            return "Se eliminó la Subtarea" ;
        } else {
            return "No se pudo eliminar la Subtarea";
        }
    }

    /**
     * Metodo para obtener una subtarea por su id.
     * @param id id de la subtarea, como parametro en la url.
     */
    @GetMapping(path = "/{id}")
    public Subtarea obtenerSubtareaPorId(@PathVariable("id") Long id){
        return subtareaService.obtenerSubtareaPorId(id);
    }

    /**
     * Metodo para poder actualizar el estado de una subtarea.
     * @param id id de la subtarea, como parametro en la url.
     * @param subtarea instancia de subtarea
     */
    @PutMapping(path = "/{id}")
    public Subtarea actualizarSubtarea(@PathVariable("id") Long id, @RequestBody Subtarea subtarea) {

        return   subtareaService.actualizarSubtarea(id, subtarea);

    }
}
