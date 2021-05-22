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
public class Cliente {

    private int id;
    private String nombres;
    private String apepat;
    private String apemat;
    private String correo;
    private String numdoc;
    private String telefono;
    private boolean estado;

    public Cliente(String nombres, String apepat, String apemat, String correo, String numdoc, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apepat = apepat;
        this.apemat = apemat;
        this.correo = correo;
        this.numdoc = numdoc;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Cliente(int id, String nombres, String apepat, String apemat, String correo, String numdoc, String telefono, boolean estado) {
        this.id = id;
        this.nombres = nombres;
        this.apepat = apepat;
        this.apemat = apemat;
        this.correo = correo;
        this.numdoc = numdoc;
        this.telefono = telefono;
        this.estado = estado;
    }
    
    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
