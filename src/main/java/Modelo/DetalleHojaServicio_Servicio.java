package Modelo;

public class DetalleHojaServicio_Servicio {
    
    //ATRIBUTOS
    private int codigoDetalleHojaServicio_Servicio;
    private HojaServicio hojaServicio_DetalleHojaServicio_Servicio;
    private Servicio servicio_DetalleHojaServicio_Servicio;
    private double precio_DetalleHojaServicio_Servicio;
    
    //CONSTRUCTOR
    public DetalleHojaServicio_Servicio(){}

    public DetalleHojaServicio_Servicio(int codigoDetalleHojaServicio_Servicio, HojaServicio hojaServicio_DetalleHojaServicio_Servicio, Servicio servicio_DetalleHojaServicio_Servicio, double precio_DetalleHojaServicio_Servicio) {
        this.codigoDetalleHojaServicio_Servicio = codigoDetalleHojaServicio_Servicio;
        this.hojaServicio_DetalleHojaServicio_Servicio = hojaServicio_DetalleHojaServicio_Servicio;
        this.servicio_DetalleHojaServicio_Servicio = servicio_DetalleHojaServicio_Servicio;
        this.precio_DetalleHojaServicio_Servicio = precio_DetalleHojaServicio_Servicio;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoDetalleHojaServicio_Servicio() {
        return codigoDetalleHojaServicio_Servicio;
    }

    public void setCodigoDetalleHojaServicio_Servicio(int codigoDetalleHojaServicio_Servicio) {
        this.codigoDetalleHojaServicio_Servicio = codigoDetalleHojaServicio_Servicio;
    }

    public HojaServicio getHojaServicio_DetalleHojaServicio_Servicio() {
        return hojaServicio_DetalleHojaServicio_Servicio;
    }

    public void setHojaServicio_DetalleHojaServicio_Servicio(HojaServicio hojaServicio_DetalleHojaServicio_Servicio) {
        this.hojaServicio_DetalleHojaServicio_Servicio = hojaServicio_DetalleHojaServicio_Servicio;
    }

    public Servicio getServicio_DetalleHojaServicio_Servicio() {
        return servicio_DetalleHojaServicio_Servicio;
    }

    public void setServicio_DetalleHojaServicio_Servicio(Servicio servicio_DetalleHojaServicio_Servicio) {
        this.servicio_DetalleHojaServicio_Servicio = servicio_DetalleHojaServicio_Servicio;
    }

    public double getPrecio_DetalleHojaServicio_Servicio() {
        return precio_DetalleHojaServicio_Servicio;
    }

    public void setPrecio_DetalleHojaServicio_Servicio(double precio_DetalleHojaServicio_Servicio) {
        this.precio_DetalleHojaServicio_Servicio = precio_DetalleHojaServicio_Servicio;
    }
    
    
}
