/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class EstadoEquipo {
    public int codigoEstadoEquipo;
    public String descripcionEstadoEquipo;
    
    public EstadoEquipo(){};
    
    public EstadoEquipo(int codigoEstadoEquipo, String descripcionEstadoEquipo){
        codigoEstadoEquipo = this.codigoEstadoEquipo;
        descripcionEstadoEquipo = this.descripcionEstadoEquipo;
    }

    public int getCodigoEstadoEquipo() {
        return codigoEstadoEquipo;
    }

    public void setCodigoEstadoEquipo(int codigoEstadoEquipo) {
        this.codigoEstadoEquipo = codigoEstadoEquipo;
    }

    public String getDescripcionEstadoEquipo() {
        return descripcionEstadoEquipo;
    }

    public void setDescripcionEstadoEquipo(String descripcionEstadoEquipo) {
        this.descripcionEstadoEquipo = descripcionEstadoEquipo;
    }
    
}
