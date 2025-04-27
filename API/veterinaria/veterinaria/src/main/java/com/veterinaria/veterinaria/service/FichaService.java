/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Ficha;
import com.veterinaria.veterinaria.repostitory.FichaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class FichaService {
    @Autowired
    private FichaRepository fichaRepository;

    public List<Ficha> getAllFichas() {
        return fichaRepository.findAll();
    }

    public Optional<Ficha> getFichaById(Long id) {
        return fichaRepository.findById(id);
    }

    public Ficha saveFicha(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    public void deleteFicha(Long id) {
        fichaRepository.deleteById(id);
    }

    public List<Ficha> getFichasByPacienteId(Long pacienteId) {
        return fichaRepository.findByPacienteId(pacienteId);
    }
}
