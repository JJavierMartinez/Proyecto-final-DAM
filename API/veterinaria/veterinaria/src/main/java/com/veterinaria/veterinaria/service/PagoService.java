/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Pago;
import com.veterinaria.veterinaria.repostitory.PagoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void deletePago(Long id) {
        pagoRepository.deleteById(id);
    }

    public List<Pago> getPagosByMetodo(String metodoPago) {
        return pagoRepository.findByMetodoPago(metodoPago);
    }

    public Double getTotalIngresos() {
        return pagoRepository.sumTotalMonto();
    }
}
