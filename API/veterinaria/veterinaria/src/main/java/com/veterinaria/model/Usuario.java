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
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nombre;
    private String apellidos;
    private String dni;
    private String user;
    private Date fechaNac;
    private Date fechaAlta;
    private String telefono;
    private String correo;
    private String direccion;
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name = "ID_Rol")
    private Rol rol;
    
    @OneToMany(mappedBy = "dueno")
    private List<Paciente> pacientes;
    @OneToMany(mappedBy = "veterinario")
    private List<Cita> citas;
    
    // Getters, Setters, Constructors
}
