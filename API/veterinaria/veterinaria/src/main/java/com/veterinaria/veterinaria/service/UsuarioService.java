/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;


import com.veterinaria.veterinaria.model.Usuario;
import com.veterinaria.veterinaria.repostitory.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> getUsuarioByDni(String dni) {
        return usuarioRepository.findByDni(dni);
    }

    public Optional<Usuario> getUsuarioByUsername(String username) {
        return usuarioRepository.findByUser(username);
    }

    public List<Usuario> getUsuariosByRol(Long rolId) {
        return usuarioRepository.findByRolId(rolId);
    }
}
