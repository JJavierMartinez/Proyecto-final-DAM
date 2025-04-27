/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.model;


import jakarta.persistence.*;
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
@Table(name = "Enfermedades")
public class Enfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedad;
    
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "enfermedad")
    private List<HistorialEnfermedad> historiales;
    
    
}
