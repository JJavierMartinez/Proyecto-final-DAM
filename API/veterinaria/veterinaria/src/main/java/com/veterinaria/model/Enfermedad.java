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
@Table(name = "Enfermedades")
public class Enfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedad;
    
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "enfermedad")
    private List<HistorialEnfermedad> historiales;
    
    // Getters, Setters, Constructors
}
