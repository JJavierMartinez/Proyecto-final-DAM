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
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    
    
}
