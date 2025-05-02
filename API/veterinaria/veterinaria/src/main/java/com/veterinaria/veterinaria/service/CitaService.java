/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Cita;
import com.veterinaria.veterinaria.repostitory.CitaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> getCitaById(Long idCita) {
        return citaRepository.findById(idCita);
    }

    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita updateCita(Long id, Cita citaDetails) {
        return citaRepository.findById(id)
                .map(cita -> {
                    cita.setMotivo(citaDetails.getMotivo());
                    cita.setFecha(citaDetails.getFecha());
                    cita.setPaciente(citaDetails.getPaciente());
                    cita.setPago(citaDetails.getPago());
                    cita.setVeterinario(citaDetails.getVeterinario());
                    return citaRepository.save(cita);
                })
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
    }

    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    public List<Cita> getCitasByPacienteId(Long pacienteId) {
        return citaRepository.findByPacienteId(pacienteId);
    }

    public List<Cita> getCitasByVeterinarioId(Long veterinarioId) {
        return citaRepository.findByVeterinarioId(veterinarioId);
    }

    public List<Cita> getCitasByFechaBetween(Date startDate, Date endDate) {
        return citaRepository.findByFechaBetween(startDate, endDate);
    }

    public List<Cita> getCitasByUsuarioId(Long usuarioId) {
        // Este método puede buscar citas donde el usuario sea el dueño del paciente o el veterinario
        return citaRepository.findByPacienteDuenoIdOrVeterinarioId(usuarioId, usuarioId);
    }
}
