package com.pruebavenko.controller;

import com.pruebavenko.model.Persona;
import com.pruebavenko.model.Medico;
import com.pruebavenko.model.Paciente;
import com.pruebavenko.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/personas") // Prefijo común para todas las rutas
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    
    /**
     * Ruta para añadir una persona (médico o paciente).
     */
    @PostMapping("/add")
    public ResponseEntity<String> añadirPersona(@RequestBody Persona persona, @RequestParam String rol) {
        String resultado = personaService.añadirPersona(persona, rol);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Funcionó esta damier 👌🎉";
    }

    /**
     * Ruta para obtener todas las personas.
     */
    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.getPersonas();
        return ResponseEntity.ok(personas);
    }

    /**
     * Ruta para obtener todos los médicos.
     */
    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> obtenerMedicos() {
        List<Medico> medicos = personaService.getMedicos();
        return ResponseEntity.ok(medicos);
    }

    /**
     * Ruta para obtener todos los pacientes.
     */
    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> obtenerPacientes() {
        List<Paciente> pacientes = personaService.getPacientes();
        return ResponseEntity.ok(pacientes);
    }

    /**
     * Ruta para buscar una persona por número de documento.
     */
    @GetMapping("/buscar")
    public ResponseEntity<Persona> buscarPersona(@RequestParam String numerodoc) {
        return personaService.findByDoc(numerodoc)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Ruta para eliminar una persona por número de documento.
     */
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarPersona(@RequestParam String numerodoc) {
        String resultado = personaService.borrarPersonaString(numerodoc);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarPersona(@RequestBody Persona persona) {
        String resultado = personaService.editarPersona(
            persona.getNumDoc(),
            persona.getNombre(),
            persona.getApellido(),
            persona.getTipoDocumento(),
            persona.getFechaExpedicion()
        );
    return ResponseEntity.ok(resultado);
}



    
}
