/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.repostitory;


import com.veterinaria.veterinaria.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jamar
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByNombre(String nombre);
}
