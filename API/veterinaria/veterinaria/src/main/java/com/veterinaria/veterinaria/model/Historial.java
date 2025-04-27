/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.model;


import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
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
@Table(name = "Historiales")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
    
    private Date fechaEvento;
    private String tipoEvento;
    private String notas;
    
    @ManyToOne
    @JoinColumn(name = "ID_Ficha")
    private Ficha ficha;
    
    @OneToMany(mappedBy = "historial")
    private List<HistorialEnfermedad> historialEnfermedades;
    
    
}
