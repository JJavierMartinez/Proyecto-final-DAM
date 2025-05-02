/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.HistorialEnfermedad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jamar
 */
@Repository
public interface HistorialEnfermedadREpository extends JpaRepository<HistorialEnfermedad, Long> {

    Optional<HistorialEnfermedad> findByIdHistorialAndIdEnfermedad(Long idHistorial, Long idEnfermedad);

    void deleteByIdHistorialAndIdEnfermedad(Long idHistorial, Long idEnfermedad);
}
