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
@Table(name = "Citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    
    private String motivo;
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;
    
    @OneToOne
    @JoinColumn(name = "ID_Pago")
    private Pago pago;
    
    @ManyToOne
    @JoinColumn(name = "ID_Veterinario")
    private Usuario veterinario;
    
    // Getters, Setters, Constructors
}
