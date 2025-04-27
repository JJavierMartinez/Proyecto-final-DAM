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
    @JoinColumn(name = "ID_Dueño", referencedColumnName = "id")
    private Usuario dueno;
    
    @OneToMany(mappedBy = "paciente")
    private List<Ficha> fichas;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
    
    
}
