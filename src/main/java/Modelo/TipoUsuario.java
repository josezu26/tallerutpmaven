/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jose
 */
public class TipoUsuario {
 
    //Atributos
    private int codigoTipoUsuario;
    private String descripcionTipoUsuario;
    
    //Constructor
    public TipoUsuario(){}

    public TipoUsuario(int codigoTipoUsuario, String descripcionTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }
    
    //Metodos Getter and Setter
    public int getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(int codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }
    
    
    
    
}
