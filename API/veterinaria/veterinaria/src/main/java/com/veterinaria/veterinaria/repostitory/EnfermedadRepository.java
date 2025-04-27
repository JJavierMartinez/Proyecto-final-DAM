/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Enfermedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jamar
 */
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long>{
    List<Enfermedad> findByNombreContainingIgnoreCase(String nombre);
}
