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
public class Hora {
    private int idHora;
    private String Hora;
    private boolean estado;

    public Hora(int idHora, String Hora, boolean estado) {
        this.idHora = idHora;
        this.Hora = Hora;
        this.estado = estado;
    }  

    public Hora(int idHora) {
        this.idHora = idHora;
    }

    public Hora() {
    }
    
    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
