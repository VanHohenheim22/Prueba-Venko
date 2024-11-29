package com.pruebavenko.model;

public class Persona {
    private String tipodocumento;
    private String numerodoc;
    private String nombre;
    private String apellido;
    private String fechaexpedicion;


    public Persona(){};


    public Persona( String tipodocumento, String numerodoc,  String nombre, String apellido, String fechaexpedicion) {
        this.tipodocumento = tipodocumento;
        this.numerodoc = numerodoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaexpedicion = fechaexpedicion;
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

    
}
