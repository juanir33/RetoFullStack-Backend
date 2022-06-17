package com.sofka.todolist.todolist.service;

import com.sofka.todolist.todolist.domain.Subtarea;
import com.sofka.todolist.todolist.repository.SubtareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class SubtareaService {


    @Autowired
    private SubtareaRepository subtareaRepository;


    public ArrayList<Subtarea> obtenerTodasLasSubtareas(){
        return (ArrayList<Subtarea>) subtareaRepository.findAll();
    }

    public Subtarea crearSubtarea(Subtarea subtarea){

        return subtareaRepository.save(subtarea);
    }

    public boolean eliminarUnaSubtarea(Long id){
        try{
            subtareaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }
    public Subtarea obtenerSubtareaPorId(Long id){
        return subtareaRepository.findById(id).orElseThrow();
    }
    @Transactional
    public Subtarea actualizarSubtarea(Long id, Subtarea subtarea) {
        subtarea.setId(id);
        subtareaRepository.save(subtarea);
        return subtarea;
    }
}

