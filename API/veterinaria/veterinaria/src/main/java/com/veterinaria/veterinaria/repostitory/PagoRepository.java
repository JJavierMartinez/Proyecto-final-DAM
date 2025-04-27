/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Pago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jamar
 */
public interface PagoRepository extends JpaRepository<Pago, Long>{
     List<Pago> findByMetodoPago(String metodoPago);
    
    @Query("SELECT SUM(p.monto) FROM Pago p")
    Double sumTotalMonto();
}
