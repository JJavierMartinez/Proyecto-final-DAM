/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author jamar
 */
public class HistorialEnfermedadId implements Serializable{
    private UUID historial;
    private UUID enfermedad;

    // Constructores
    public HistorialEnfermedadId() {}

    public HistorialEnfermedadId(UUID historial, UUID enfermedad) {
        this.historial = historial;
        this.enfermedad = enfermedad;
    }

    // Getters y setters
    public UUID getHistorial() { return historial; }
    public void setHistorial(UUID historial) { this.historial = historial; }
    
    public UUID getEnfermedad() { return enfermedad; }
    public void setEnfermedad(UUID enfermedad) { this.enfermedad = enfermedad; }

    // equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialEnfermedadId that = (HistorialEnfermedadId) o;
        return historial.equals(that.historial) &&
               enfermedad.equals(that.enfermedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historial, enfermedad);
    }
}
