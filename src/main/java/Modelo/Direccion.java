package Modelo;

/**
 *
 * @author Jose
 */
public class Direccion {
    
    private int codigoDireccion;
    private String descripcionDireccion;
    private Distrito distrito;
    
    public Direccion(){}

    //Constructor
    public Direccion(int codigoDireccion, String descripcionDireccion, Distrito distrito) {
        this.codigoDireccion = codigoDireccion;
        this.descripcionDireccion = descripcionDireccion;
        this.distrito = distrito;
    }

    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    public String getDescripcionDireccion() {
        return descripcionDireccion;
    }

    public void setDescripcionDireccion(String descripcionDireccion) {
        this.descripcionDireccion = descripcionDireccion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
    
}
