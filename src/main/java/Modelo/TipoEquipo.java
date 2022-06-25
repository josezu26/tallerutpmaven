package Modelo;

public class TipoEquipo {
    
    //ATRIBUTOS
    private int codigoTipoEquipo;
    private String descripcionTipoEquipo;
    
    //CONSTRUCTOR
    public TipoEquipo(){}
    
    public TipoEquipo(int codigoTipoEquipo, String descripcionTipoEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
        this.descripcionTipoEquipo = descripcionTipoEquipo;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoTipoEquipo() {
        return codigoTipoEquipo;
    }

    public void setCodigoTipoEquipo(int codigoTipoEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
    }

    public String getDescripcionTipoEquipo() {
        return descripcionTipoEquipo;
    }

    public void setDescripcionTipoEquipo(String descripcionTipoEquipo) {
        this.descripcionTipoEquipo = descripcionTipoEquipo;
    }
    
}
