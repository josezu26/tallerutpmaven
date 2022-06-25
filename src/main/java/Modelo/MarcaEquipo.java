package Modelo;

public class MarcaEquipo {
    
    //ATRIBUTOS
    private int codigoMarcaEquipo;
    private String descripcionMarcaEquipo;
    
    //CONSTRUCTOR
    public MarcaEquipo(){}

    public MarcaEquipo(int codigoMarcaEquipo, String descripcionMarcaEquipo) {
        this.codigoMarcaEquipo = codigoMarcaEquipo;
        this.descripcionMarcaEquipo = descripcionMarcaEquipo;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoMarcaEquipo() {
        return codigoMarcaEquipo;
    }

    public void setCodigoMarcaEquipo(int codigoMarcaEquipo) {
        this.codigoMarcaEquipo = codigoMarcaEquipo;
    }

    public String getDescripcionMarcaEquipo() {
        return descripcionMarcaEquipo;
    }

    public void setDescripcionMarcaEquipo(String descripcionMarcaEquipo) {
        this.descripcionMarcaEquipo = descripcionMarcaEquipo;
    }
    
}
