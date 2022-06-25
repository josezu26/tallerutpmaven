/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jose
 */
public class Especialidad {
    
    private int codigoEspecialidad;
    private String descripcionEspecialidad;

    
    public Especialidad(){}
    
    //Constructor   
    public Especialidad(int codigoEspecialidad, String descripcionEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.descripcionEspecialidad = descripcionEspecialidad;
    }

    
    
    public int getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(int codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public String getDescripcionEspecialidad() {
        return descripcionEspecialidad;
    }

    public void setDescripcionEspecialidad(String descripcionEspecialidad) {
        this.descripcionEspecialidad = descripcionEspecialidad;
    }
    
    
    
}
