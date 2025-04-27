/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Cita;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jamar
 */
public interface CitaRepository extends JpaRepository<Cita, Long>{
    List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByVeterinarioId(Long veterinarioId);
    List<Cita> findByFechaBetween(Date startDate, Date endDate);
    
    @Query("SELECT c FROM Cita c WHERE c.paciente.dueno.id = ?1 OR c.veterinario.id = ?1")
    List<Cita> findByPacienteDuenoIdOrVeterinarioId(Long usuarioId, Long sameUsuarioId);
}
