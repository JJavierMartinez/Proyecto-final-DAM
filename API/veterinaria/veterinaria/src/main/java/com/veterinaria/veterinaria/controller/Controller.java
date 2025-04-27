/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.controller;


import com.veterinaria.veterinaria.model.*;
import com.veterinaria.veterinaria.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author jamar
 */
@RestController
@RequestMapping("/api/veterinaria")
public class Controller {
    // Servicios inyectados
    @Autowired
    private PacienteService pacienteService;
    
    @Autowired
    private FichaService fichaService;
    
    @Autowired
    private CitaService citaService;
    
    @Autowired
    private PagoService pagoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private HistorialService historialService;
    
    @Autowired
    private EnfermedadService enfermedadService;
    
    @Autowired
    private HistorialEnfermedadService historialEnfermedadService;

    // ========== PACIENTES ==========
    @GetMapping("/pacientes")
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pacientes")
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @PutMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        return pacienteService.getPacienteById(id)
                .map(paciente -> {
                    paciente.setNombre(pacienteDetails.getNombre());
                    paciente.setApellidos(pacienteDetails.getApellidos());
                    paciente.setDni(pacienteDetails.getDni());
                    paciente.setFechaNac(pacienteDetails.getFechaNac());
                    paciente.setSeguro(pacienteDetails.getSeguro());
                    return ResponseEntity.ok(pacienteService.savePaciente(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok().build();
    }

    // ========== FICHAS ==========
    @GetMapping("/fichas")
    public List<Ficha> getAllFichas() {
        return fichaService.getAllFichas();
    }

    @GetMapping("/fichas/{id}")
    public ResponseEntity<Ficha> getFichaById(@PathVariable Long id) {
        return fichaService.getFichaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/fichas")
    public Ficha createFicha(@RequestBody Ficha ficha) {
        return fichaService.saveFicha(ficha);
    }

    @PutMapping("/fichas/{id}")
    public ResponseEntity<Ficha> updateFicha(@PathVariable Long id, @RequestBody Ficha fichaDetails) {
        return fichaService.getFichaById(id)
                .map(ficha -> {
                    ficha.setEspecie(fichaDetails.getEspecie());
                    ficha.setRaza(fichaDetails.getRaza());
                    ficha.setFechaAlta(fichaDetails.getFechaAlta());
                    return ResponseEntity.ok(fichaService.saveFicha(ficha));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/fichas/{id}")
    public ResponseEntity<?> deleteFicha(@PathVariable Long id) {
        fichaService.deleteFicha(id);
        return ResponseEntity.ok().build();
    }

    // ========== CITAS ==========
    @GetMapping("/citas")
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        return citaService.getCitaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/citas")
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.saveCita(cita);
    }

    @PutMapping("/citas/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Long id, @RequestBody Cita citaDetails) {
        return citaService.getCitaById(id)
                .map(cita -> {
                    cita.setMotivo(citaDetails.getMotivo());
                    cita.setFecha(citaDetails.getFecha());
                    return ResponseEntity.ok(citaService.saveCita(cita));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<?> deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
        return ResponseEntity.ok().build();
    }

    // ========== PAGOS ==========
    @GetMapping("/pagos")
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/pagos/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        return pagoService.getPagoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pagos")
    public Pago createPago(@RequestBody Pago pago) {
        return pagoService.savePago(pago);
    }

    @PutMapping("/pagos/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pagoDetails) {
        return pagoService.getPagoById(id)
                .map(pago -> {
                    pago.setMonto(pagoDetails.getMonto());
                    pago.setFecha(pagoDetails.getFecha());
                    pago.setMetodoPago(pagoDetails.getMetodoPago());
                    return ResponseEntity.ok(pagoService.savePago(pago));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/pagos/{id}")
    public ResponseEntity<?> deletePago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return ResponseEntity.ok().build();
    }

    // ========== USUARIOS ==========
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.getUsuarioById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setApellidos(usuarioDetails.getApellidos());
                    usuario.setDni(usuarioDetails.getDni());
                    usuario.setUser(usuarioDetails.getUser());
                    usuario.setFechaNac(usuarioDetails.getFechaNac());
                    usuario.setFechaAlta(usuarioDetails.getFechaAlta());
                    usuario.setTelefono(usuarioDetails.getTelefono());
                    usuario.setCorreo(usuarioDetails.getCorreo());
                    usuario.setDireccion(usuarioDetails.getDireccion());
                    usuario.setContrasena(usuarioDetails.getContrasena());
                    return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }

    // ========== HISTORIALES ==========
    @GetMapping("/historiales")
    public List<Historial> getAllHistoriales() {
        return historialService.getAllHistoriales();
    }

    @GetMapping("/historiales/{id}")
    public ResponseEntity<Historial> getHistorialById(@PathVariable Long id) {
        return historialService.getHistorialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/historiales")
    public Historial createHistorial(@RequestBody Historial historial) {
        return historialService.saveHistorial(historial);
    }

    @PutMapping("/historiales/{id}")
    public ResponseEntity<Historial> updateHistorial(@PathVariable Long id, @RequestBody Historial historialDetails) {
        return historialService.getHistorialById(id)
                .map(historial -> {
                    historial.setFechaEvento(historialDetails.getFechaEvento());
                    historial.setTipoEvento(historialDetails.getTipoEvento());
                    historial.setNotas(historialDetails.getNotas());
                    return ResponseEntity.ok(historialService.saveHistorial(historial));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/historiales/{id}")
    public ResponseEntity<?> deleteHistorial(@PathVariable Long id) {
        historialService.deleteHistorial(id);
        return ResponseEntity.ok().build();
    }

    // ========== ENFERMEDADES ==========
    @GetMapping("/enfermedades")
    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadService.getAllEnfermedades();
    }

    @GetMapping("/enfermedades/{id}")
    public ResponseEntity<Enfermedad> getEnfermedadById(@PathVariable Long id) {
        return enfermedadService.getEnfermedadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/enfermedades")
    public Enfermedad createEnfermedad(@RequestBody Enfermedad enfermedad) {
        return enfermedadService.saveEnfermedad(enfermedad);
    }

    @PutMapping("/enfermedades/{id}")
    public ResponseEntity<Enfermedad> updateEnfermedad(@PathVariable Long id, @RequestBody Enfermedad enfermedadDetails) {
        return enfermedadService.getEnfermedadById(id)
                .map(enfermedad -> {
                    enfermedad.setNombre(enfermedadDetails.getNombre());
                    enfermedad.setDescripcion(enfermedadDetails.getDescripcion());
                    return ResponseEntity.ok(enfermedadService.saveEnfermedad(enfermedad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/enfermedades/{id}")
    public ResponseEntity<?> deleteEnfermedad(@PathVariable Long id) {
        enfermedadService.deleteEnfermedad(id);
        return ResponseEntity.ok().build();
    }

    // ========== HISTORIAL ENFERMEDADES ==========
    @GetMapping("/historial-enfermedades")
    public List<HistorialEnfermedad> getAllHistorialEnfermedades() {
        return historialEnfermedadService.getAll();
    }

    @PostMapping("/historial-enfermedades")
    public HistorialEnfermedad createHistorialEnfermedad(@RequestBody HistorialEnfermedad historialEnfermedad) {
        return historialEnfermedadService.create(historialEnfermedad);
    }

    @PutMapping("/historial-enfermedades")
    public ResponseEntity<HistorialEnfermedad> updateHistorialEnfermedad(
            @RequestParam Long idHistorial,
            @RequestParam Long idEnfermedad,
            @RequestBody HistorialEnfermedad historialEnfermedadDetails) {
        
        return historialEnfermedadService.getByIds(idHistorial, idEnfermedad)
                .map(he -> {
                    he.setFechaDiagnostico(historialEnfermedadDetails.getFechaDiagnostico());
                    he.setEstado(historialEnfermedadDetails.getEstado());
                    he.setTratamiento(historialEnfermedadDetails.getTratamiento());
                    he.setObservaciones(historialEnfermedadDetails.getObservaciones());
                    return ResponseEntity.ok(historialEnfermedadService.create(he));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/historial-enfermedades")
    public ResponseEntity<?> deleteHistorialEnfermedad(
            @RequestParam Long idHistorial,
            @RequestParam Long idEnfermedad) {
        
        historialEnfermedadService.delete(idHistorial, idEnfermedad);
        return ResponseEntity.ok().build();
    }

    // ========== ENDPOINTS ESPECIALES ==========
    
    @GetMapping("/pacientes/{id}/fichas")
    public List<Ficha> getFichasByPacienteId(@PathVariable Long id) {
        return fichaService.getFichasByPacienteId(id);
    }

    @GetMapping("/pacientes/{id}/citas")
    public List<Cita> getCitasByPacienteId(@PathVariable Long id) {
        return citaService.getCitasByPacienteId(id);
    }

    @GetMapping("/fichas/{id}/historiales")
    public List<Historial> getHistorialesByFichaId(@PathVariable Long id) {
        return historialService.getHistorialesByFichaId(id);
    }

    @GetMapping("/usuarios/{id}/pacientes")
    public List<Paciente> getPacientesByUsuarioId(@PathVariable Long id) {
        return pacienteService.getPacientesByUsuarioId(id);
    }

    @GetMapping("/usuarios/{id}/citas")
    public List<Cita> getCitasByUsuarioId(@PathVariable Long id) {
        return citaService.getCitasByUsuarioId(id);
    }
}
