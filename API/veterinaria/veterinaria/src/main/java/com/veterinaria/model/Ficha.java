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
@Table(name = "Fichas")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicha;
    
    private String especie;
    private String raza;
    private Date fechaAlta;
    
    @ManyToOne
    @JoinColumn(name = "ID_Paciente")
    private Paciente paciente;
    
    @OneToMany(mappedBy = "ficha")
    private List<Historial> historiales;
    
    
}
