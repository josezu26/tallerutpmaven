package Modelo;

public class EstadoHojaServicio {
    
    //ATRIBUTOS
    public int codigoEstadoHojaServicio;
    public String descripcionEstadoHojaServicio;
    
    //CONSTRUCTOR
    public EstadoHojaServicio(){}

    public EstadoHojaServicio(int codigoEstadoHojaServicio, String descripcionEstadoHojaServicio) {
        this.codigoEstadoHojaServicio = codigoEstadoHojaServicio;
        this.descripcionEstadoHojaServicio = descripcionEstadoHojaServicio;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoEstadoHojaServicio() {
        return codigoEstadoHojaServicio;
    }

    public void setCodigoEstadoHojaServicio(int codigoEstadoHojaServicio) {
        this.codigoEstadoHojaServicio = codigoEstadoHojaServicio;
    }

    public String getDescripcionEstadoHojaServicio() {
        return descripcionEstadoHojaServicio;
    }

    public void setDescripcionEstadoHojaServicio(String descripcionEstadoHojaServicio) {
        this.descripcionEstadoHojaServicio = descripcionEstadoHojaServicio;
    }
    
    
}
