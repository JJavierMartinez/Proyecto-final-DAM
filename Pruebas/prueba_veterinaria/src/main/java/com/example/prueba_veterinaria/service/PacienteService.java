/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.Paciente;
import com.example.prueba_veterinaria.repository.PacienteRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(UUID id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deleteById(UUID id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> findByDuenoId(UUID duenoId) {
        return pacienteRepository.findByDuenoUuid(duenoId);
    }

    public List<Paciente> findByEspecie(String especie) {
        return pacienteRepository.findByEspecie(especie);
    }
}
