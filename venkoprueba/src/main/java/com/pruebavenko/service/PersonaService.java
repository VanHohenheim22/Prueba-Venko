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


    public String añadirPersona(Persona persona, String rol) {


        if (persona.getTipoPer().equals("medico")) {
            boolean duplicado = medicos.stream()
            .anyMatch(m -> m.getNumDoc().equals(persona.getNumDoc())
                    && m.getTipoDocumento().equals(persona.getTipoDocumento()));
            if (duplicado) {
                return "Ya existe un médico con el tipo de documento " + persona.getTipoDocumento() + " Y número: " + persona.getNumDoc();
            }

            boolean dupliNum = medicos.stream().anyMatch(m -> m.getNumDoc().equals(persona.getNumDoc()));
            if (dupliNum) {
            return "Ya existe una persona con el número de documento " + persona.getNumDoc();
            }

            Medico medicog = new Medico(persona.getTipoDocumento(), persona.getNamec(), persona.getApeliido(), persona.getFexhaExp(),
            persona.getFexhaExp(), persona.getTipoPer(), rol );

            medicos.add(medicog);
            personas.add(persona);
            return "Se añadió el médico exitosamente";
        }

        if (persona.getTipoPer().equals("paciente")) {
            boolean duplicado = pacientes.stream()
            .anyMatch(p -> p.getNumDoc().equals(persona.getNumDoc())
                    && p.getTipoDocumento().equals(persona.getTipoDocumento()));
            if (duplicado) {
                return "Ya existe un paciente con el tipo de documento " + persona.getTipoDocumento() + " Y número: " + persona.getNumDoc();
            }

            boolean dupliNum = pacientes.stream().anyMatch(m -> m.getNumDoc().equals(persona.getNumDoc()));
            if (dupliNum) {
            return "Ya existe un paciente con el número de documento " + persona.getNumDoc();
            }

            Paciente pacienteg = new Paciente(persona.getTipoDocumento(), persona.getNamec(), persona.getApeliido(), persona.getFexhaExp(),
            persona.getFexhaExp(), persona.getTipoPer(), rol );

            pacientes.add(pacienteg);
            personas.add(persona);
            return "Se añadió el paciente exitosamente";
        }
        

        return "Debe elegir entre paciente o medico";
    }

    public Optional<Persona> findByDoc(String numDoc) {

        return personas.stream().filter(p -> p.getNumDoc().equals(numDoc)).findFirst();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public String borrarPersonaString(String numdoc) {
        
        return "gas";
    }

}
