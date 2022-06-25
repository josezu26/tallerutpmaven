package Modelo;

/**
 *
 * @author Jose
 */
public class Distrito {
    
    private int codigoDistrito;
    private String descripcionDistrito;
    
    public Distrito(){}

    //Constructor
    public Distrito(int codigoDistrito, String descripcionDistrito) {
        this.codigoDistrito = codigoDistrito;
        this.descripcionDistrito = descripcionDistrito;
    }

    public int getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(int codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getDescripcionDistrito() {
        return descripcionDistrito;
    }

    public void setDescripcionDistrito(String descripcionDistrito) {
        this.descripcionDistrito = descripcionDistrito;
    }
    
    
    
}
