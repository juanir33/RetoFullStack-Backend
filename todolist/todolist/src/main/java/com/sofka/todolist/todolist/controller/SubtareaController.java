package com.sofka.todolist.todolist.controller;

import com.sofka.todolist.todolist.domain.Subtarea;
import com.sofka.todolist.todolist.service.SubtareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/subtarea")
public class SubtareaController {

    @Autowired
    private SubtareaService subtareaService;

    @GetMapping()
    public ArrayList<Subtarea> obtenerTodasSubtareas(){
        return (ArrayList<Subtarea>) subtareaService.obtenerTodasLasSubtareas();
    }

    @PostMapping()
    public Subtarea crearNuevaSubtarea(@RequestBody Subtarea subtarea){

        return subtareaService.crearSubtarea(subtarea);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarUnaSubtarea(@PathVariable("id") Long id){
        boolean ok = subtareaService.eliminarUnaSubtarea(id);
        if (ok) {
            return "Se eliminó la Subtarea" ;
        } else {
            return "No se pudo eliminar la Subtarea";
        }
    }
    @GetMapping(path = "/{id}")
    public Subtarea obtenerSubtareaPorId(@PathVariable("id") Long id){
        return subtareaService.obtenerSubtareaPorId(id);
    }
    @PutMapping(path = "/{id}")
    public Subtarea actualizarSubtarea(@PathVariable("id") Long id, @RequestBody Subtarea subtarea) {

        return   subtareaService.actualizarSubtarea(id, subtarea);

    }
}
