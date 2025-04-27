/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Historial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jamar
 */
public interface HistorialRepository extends JpaRepository<Historial, Long>{
    List<Historial> findByFichaId(Long fichaId);
    List<Historial> findByTipoEventoContainingIgnoreCase(String tipoEvento);
}
