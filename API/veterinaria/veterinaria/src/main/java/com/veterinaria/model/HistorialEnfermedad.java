/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.model;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "historiales_enfermedades")
public class HistorialEnfermedad {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Historial")
    private Historial historial;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Enfermedad")
    private Enfermedad enfermedad;
    
    private Date fechaDiagnostico;
    private String estado;
    private String tratamiento;
    private String observaciones;
    
    // Getters, Setters, Constructors
}
