package com.pruebavenko.service;

import com.pruebavenko.model.Persona;
import com.pruebavenko.model.Medico;
import com.pruebavenko.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonaService {

    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<Medico> medicos = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    /**
     * Método para añadir una persona (médico o paciente) según su tipo.
     */
    public String añadirPersona(Persona persona, String rol) {

        System.out.println("Persona recibida: " + persona);
        if (persona.getNumDoc() == null || persona.getTipoDocumento() == null || persona.getTipoPersona() == null) {
            return "Error: Los campos  nombre " + persona.getNombre() + "' tipoDocumento' " + persona.getTipoDocumento() +  " 'tipoPer' " + persona.getTipoPersona() +
            " apellido " +persona.getApellido() + " fechaexp " + persona.getFechaExpedicion() + " tipoper " + persona.getTipoPersona();
        }
    
        // Validación para médicos
        if (persona.getTipoPersona().equalsIgnoreCase("medico")) {
            if (persona.getNombre() == null || persona.getApellido() == null) {
                return "Error: El nombre y el apellido son obligatorios para un médico.";
            }
    
            boolean duplicado = medicos.stream()
                .anyMatch(m -> m.getNumDoc().equals(persona.getNumDoc()))
                || pacientes.stream()
                .anyMatch(p -> p.getNumDoc().equals(persona.getNumDoc()));

            if (duplicado) {
                return "Ya existe un médico con el tipo de documento " + persona.getTipoDocumento()
                        + " y número: " + persona.getNumDoc();
            }
    
            Medico medicog = new Medico(
                persona.getTipoDocumento(),
                persona.getNumDoc(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getFechaExpedicion(),
                persona.getTipoPersona(),
                rol
            );

    
            medicos.add(medicog);
            personas.add(medicog); 
            return "Se añadió el médico exitosamente";
        }
    
        // Validación para pacientes
        if (persona.getTipoPersona().equalsIgnoreCase("paciente")) {
            if (persona.getNombre() == null || persona.getApellido() == null) {
                return "Error: El nombre y el apellido son obligatorios para un paciente.";
            }
    
            boolean duplicado = medicos.stream().anyMatch(m -> m.getNumDoc().equals(persona.getNumDoc())) || pacientes.stream()
    .anyMatch(p -> p.getNumDoc().equals(persona.getNumDoc()));

            if (duplicado) {
                return "Ya existe un paciente con el tipo de documento " + persona.getTipoDocumento()
                        + " y número: " + persona.getNumDoc();
            }
    
            Paciente pacienteg = new Paciente(
                    persona.getTipoDocumento(),
                    persona.getNumDoc(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getFechaExpedicion(),
                    persona.getTipoPersona(),
                    rol 
            );
    
            pacientes.add(pacienteg);
            personas.add(pacienteg); // Añadir a la lista general
            return "Se añadió el paciente exitosamente";
        }
    
        return "Debe elegir entre 'medico' o 'paciente'";
    }
    

    /**
     * Método para buscar una persona por su número de documento.
     */
    public Optional<Persona> findByDoc(String numDoc) {
        return personas.stream().filter(p -> p.getNumDoc().equals(numDoc)).findFirst();
    }

    /**
     * Obtener todas las personas registradas.
     */
    public List<Persona> getPersonas() {
        return personas;
    }

    /**
     * Obtener todos los médicos registrados.
     */
    public List<Medico> getMedicos() {
        return medicos;
    }

    /**
     * Obtener todos los pacientes registrados.
     */
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Método para eliminar una persona por su número de documento.
     */
    public String borrarPersonaString(String numDoc) {
        // Eliminar médicos y pacientes según el número de documento
        boolean medicoEliminado = medicos.removeIf(m -> m.getNumDoc().equals(numDoc));
        boolean pacienteEliminado = pacientes.removeIf(p -> p.getNumDoc().equals(numDoc));
        boolean personaEliminada = personas.removeIf(p -> p.getNumDoc().equals(numDoc));

        if (medicoEliminado && personaEliminada) {
            return "Médico eliminado exitosamente";
        }

        if (pacienteEliminado && personaEliminada) {
            return "Paciente eliminado exitosamente";
        }

        return "No se encontró una persona con el número de documento " + numDoc;
    }

    public String editarPersona(String numerodoc, String nombre, String apellido, String tipoDocumento, String fechaExpedicion) {
        Optional<Persona> personaOpt = findByDoc(numerodoc);
        
        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setTipoDocumento(tipoDocumento);
            persona.setFechaExpedicion(fechaExpedicion);
            return "Información actualizada correctamente";
        }
    
        return "No se encontró una persona con el número de documento " + numerodoc ;
    }
    
}
