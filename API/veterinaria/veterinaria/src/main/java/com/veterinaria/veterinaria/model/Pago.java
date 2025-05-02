/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.model;


import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jamar
 */
@Getter  
@Setter  
@NoArgsConstructor  
@AllArgsConstructor
@Entity
@Table(name = "Pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;
    
    private Double monto;
    private Date fecha;
    private String metodoPago;
    
    @OneToOne(mappedBy = "pago")
    private Cita cita;
    
    
}
