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
public class Sala {
    private int idSala;
    private String descripcion;
    private int aforo;
    private boolean estado;

    public Sala(int idSala, String descripcion, int aforo, boolean estado) {
        this.idSala = idSala;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.estado = estado;
    }

    public Sala() {
    }

    public Sala(int idSala) {
        this.idSala = idSala;
    }
   
    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
