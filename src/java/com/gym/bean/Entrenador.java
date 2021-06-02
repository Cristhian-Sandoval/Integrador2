/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.bean;

/**
 *
 * @author Usuario
 */
public class Entrenador {
    private int id;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    private String celular;
    private String correo;
    private String dni;
    private boolean estado;

    public Entrenador() {
    }

    public Entrenador(int id) {
        this.id = id;
    }

    public Entrenador(String nombre, String apellidopat, String apellidomat, String celular, String correo, String dni) {
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.celular = celular;
        this.correo = correo;
        this.dni = dni;
    }

    public Entrenador(int id, String nombre, String apellidopat, String apellidomat, String celular, String correo, String dni, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.celular = celular;
        this.correo = correo;
        this.dni = dni;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    


   
    
    
}
