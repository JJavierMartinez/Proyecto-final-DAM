/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Paciente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author jamar
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    List<Paciente> findByDuenoId(Long duenoId);
    Optional<Paciente> findByDni(String dni);
}
