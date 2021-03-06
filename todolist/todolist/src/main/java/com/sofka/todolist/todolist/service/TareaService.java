package com.sofka.todolist.todolist.service;

import com.sofka.todolist.todolist.domain.Tarea;
import com.sofka.todolist.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    TareaRepository tareaRepository;
    public ArrayList<Tarea> obtenerTodasLasTareas() {
        return (ArrayList<Tarea>) tareaRepository.findAll();
    }

    public Tarea  crearTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> obtenerPorId(Long id){
        return tareaRepository.findById(id);
    }

    @Transactional
    public Tarea actualizarTarea(Long id, Tarea tarea) {
        tarea.setId(id);
        tareaRepository.save(tarea);
        return tarea;
    }

    public boolean eliminarTarea(Long id) {
        try{
            tareaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}

