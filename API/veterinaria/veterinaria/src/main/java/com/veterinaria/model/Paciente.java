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
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fechaNac;
    private String seguro;
    
    @ManyToOne
    @JoinColumn(name = "ID_Dueño")
    private Usuario dueno;
    
    @OneToMany(mappedBy = "paciente")
    private List<Ficha> fichas;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
    
    // Getters, Setters, Constructors
}
