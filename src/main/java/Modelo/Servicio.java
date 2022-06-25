package Modelo;

public class Servicio {
    
    //ATRIBUTOS
    private int codigoServicio;
    private String nombreServicio;
    private String descripcionServicio;
    private double precioServicio;
    
    //CONSTRUCTOR
    public Servicio(){}

    public Servicio(int codigoServicio, String nombreServicio, String descripcionServicio, double precioServicio) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }
    
    
}
