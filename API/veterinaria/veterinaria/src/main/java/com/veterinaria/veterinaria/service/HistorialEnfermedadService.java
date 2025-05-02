/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.HistorialEnfermedad;
import com.veterinaria.veterinaria.repostitory.HistorialEnfermedadREpository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class HistorialEnfermedadService {
    @Autowired
    private HistorialEnfermedadREpository repository;

    public List<HistorialEnfermedad> getAll() {
        return repository.findAll();
    }

    public Optional<HistorialEnfermedad> getByIds(Long idHistorial, Long idEnfermedad) {
        return repository.findByIdHistorialAndIdEnfermedad(idHistorial, idEnfermedad);
    }

    public HistorialEnfermedad create(HistorialEnfermedad historialEnfermedad) {
        return repository.save(historialEnfermedad);
    }

    public Optional<HistorialEnfermedad> update(Long idHistorial, Long idEnfermedad, HistorialEnfermedad detalles) {
        return repository.findByIdHistorialAndIdEnfermedad(idHistorial, idEnfermedad)
                .map(he -> {
                    he.setFechaDiagnostico(detalles.getFechaDiagnostico());
                    he.setEstado(detalles.getEstado());
                    he.setTratamiento(detalles.getTratamiento());
                    he.setObservaciones(detalles.getObservaciones());
                    return repository.save(he);
                });
    }

    public void delete(Long idHistorial, Long idEnfermedad) {
        repository.deleteByIdHistorialAndIdEnfermedad(idHistorial, idEnfermedad);
    }
}
