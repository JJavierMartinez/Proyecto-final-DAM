/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Ficha;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jamar
 */
@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long>{
    List<Ficha> findByPacienteId(Long pacienteId);
    List<Ficha> findByEspecieContainingIgnoreCase(String especie);
}
