/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Historial;
import com.veterinaria.veterinaria.repostitory.HistorialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    public List<Historial> getAllHistoriales() {
        return historialRepository.findAll();
    }

    public Optional<Historial> getHistorialById(Long id) {
        return historialRepository.findById(id);
    }

    public Historial saveHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

    public void deleteHistorial(Long id) {
        historialRepository.deleteById(id);
    }

    public List<Historial> getHistorialesByFichaId(Long fichaId) {
        return historialRepository.findByFichaId(fichaId);
    }

    public List<Historial> getHistorialesByTipoEvento(String tipoEvento) {
        return historialRepository.findByTipoEventoContainingIgnoreCase(tipoEvento);
    }
}
