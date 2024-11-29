package com.pruebavenko.model;

public class Persona {
    private String tipodocumento;
    private String numerodoc;
    private String nombre;
    private String apellido;
    private String fechaexpedicion;
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



    public void setTipoDoc(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }


    public String getTipoDocumento() {
        return tipodocumento;
    }

    public void setNumdoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public String getNumDoc() {
        return numerodoc;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getNamec() {
        return nombre;
    }

    public void setApeliido(String apellido) {
        this.apellido = apellido;
    }

    public String getApeliido() {
        return apellido;
    }

    public void setFexhaExp(String fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    public String getFexhaExp() {
        return fechaexpedicion;
    }

    public void setTipoPer(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getTipoPer() {
        return tipopersona;
    }
}
