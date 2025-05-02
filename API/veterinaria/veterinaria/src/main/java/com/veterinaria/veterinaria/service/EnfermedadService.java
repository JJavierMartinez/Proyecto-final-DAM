/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Enfermedad;
import com.veterinaria.veterinaria.repostitory.EnfermedadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class EnfermedadService {
    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadRepository.findAll();
    }

    public Optional<Enfermedad> getEnfermedadById(Long idEnfermedad) {
        return enfermedadRepository.findById(idEnfermedad);
    }

    public Enfermedad saveEnfermedad(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    public void deleteEnfermedad(Long idEnfermedad) {
        enfermedadRepository.deleteById(idEnfermedad);
    }

    public List<Enfermedad> getEnfermedadesByNombre(String nombre) {
        return enfermedadRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
