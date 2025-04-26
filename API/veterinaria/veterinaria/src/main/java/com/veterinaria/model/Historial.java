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
    
    // Getters, Setters, Constructors
}
