package com.pruebavenko.model;

public class Medico extends Persona {
    private String especialidad;

    public Medico() {}

    public Medico(String tipodocumento, String numerodoc, String nombre, String apellido, String fechaexpedicion, String tipopersona, String especialidad) {
        super(tipodocumento, numerodoc, nombre, apellido, fechaexpedicion, tipopersona);
        this.especialidad = especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

