package com.pruebavenko.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {
    @JsonProperty("tipodocumento")
    private String tipodocumento;

    @JsonProperty("numerodoc")
    private String numerodoc;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("fechaexpedicion")
    private String fechaexpedicion;

    @JsonProperty("tipopersona")
    private String tipopersona;


    public Persona(){};


    public Persona( String tipodocumento, String numerodoc,  String nombre, String apellido, String fechaexpedicion, String tipopersona) {
        this.tipodocumento = tipodocumento;
        this.numerodoc = numerodoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaexpedicion = fechaexpedicion;
        this.tipopersona = tipopersona;
    };



    @JsonProperty("tipodocumento")
    public String getTipoDocumento() {
        return tipodocumento;
    }

    @JsonProperty("tipodocumento")
    public void setTipoDocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @JsonProperty("numerodoc")
    public String getNumDoc() {
        return numerodoc;
    }

    @JsonProperty("numerodoc")
    public void setNumDoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("apellido")
    public String getApellido() {
        return apellido;
    }

    @JsonProperty("apellido")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @JsonProperty("fechaexpedicion")
    public String getFechaExpedicion() {
        return fechaexpedicion;
    }

    @JsonProperty("fechaexpedicion")
    public void setFechaExpedicion(String fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    @JsonProperty("tipopersona")
    public String getTipoPersona() {
        return tipopersona;
    }

    @JsonProperty("tipopersona")
    public void setTipoPersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }
}
