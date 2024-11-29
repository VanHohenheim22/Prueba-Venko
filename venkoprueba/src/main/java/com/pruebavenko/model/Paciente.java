package com.pruebavenko.model;

public class Paciente extends Persona {
    private String eps;

    public Paciente() {}

    public Paciente ( String tipodocumento, String numerodoc,  String nombre, String apellido, String fechaexpedicion, String tipopersona, String eps) {
        super(tipodocumento, numerodoc, nombre, apellido, fechaexpedicion, tipopersona);

        this.eps = eps;
    }

    public void setEspecialidad( String eps) {
        this.eps = eps;
    }

    public String getEspecialidad() {
        return eps;
    }
}
