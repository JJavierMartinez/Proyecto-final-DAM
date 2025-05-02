/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.prueba_veterinaria.repository;

import com.example.prueba_veterinaria.model.Cita;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jamar
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, UUID>{
    List<Cita> findByPacienteUuid(UUID pacienteId);
    List<Cita> findByUsuarioUuid(UUID veterinarioId);
    List<Cita> findByFecha(Date fecha);
}
