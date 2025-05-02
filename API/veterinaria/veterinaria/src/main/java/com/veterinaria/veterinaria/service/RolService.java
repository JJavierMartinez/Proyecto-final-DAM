/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Rol;
import com.veterinaria.veterinaria.repostitory.RolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> getRolById(Long id) {
        return rolRepository.findById(id);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    public Optional<Rol> getRolByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
