package Modelo;

public class DetalleHojaServicio_Repuesto {
    
    //ATRIBUTOS
    private int codigoDetalleHojaServicio_Repuesto;
    private HojaServicio hojaServicio_DetalleHojaServicio_Repuesto;
    private Repuesto repuesto_DetalleHojaServicio_Repuesto;
    private int cantidad_DetalleHojaServicio_Repuesto;
    private double subtotal_DetalleHojaServicio_Repuesto;
    
    //CONSTRUCTOR
    public DetalleHojaServicio_Repuesto(){}
    
    public DetalleHojaServicio_Repuesto(int codigoDetalleHojaServicio_Repuesto, HojaServicio hojaServicio_DetalleHojaServicio_Repuesto, Repuesto repuesto_DetalleHojaServicio_Repuesto, int cantidad_DetalleHojaServicio_Repuesto, double subtotal_DetalleHojaServicio_Repuesto) {
        this.codigoDetalleHojaServicio_Repuesto = codigoDetalleHojaServicio_Repuesto;
        this.hojaServicio_DetalleHojaServicio_Repuesto = hojaServicio_DetalleHojaServicio_Repuesto;
        this.repuesto_DetalleHojaServicio_Repuesto = repuesto_DetalleHojaServicio_Repuesto;
        this.cantidad_DetalleHojaServicio_Repuesto = cantidad_DetalleHojaServicio_Repuesto;
        this.subtotal_DetalleHojaServicio_Repuesto = subtotal_DetalleHojaServicio_Repuesto;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoDetalleHojaServicio_Repuesto() {
        return codigoDetalleHojaServicio_Repuesto;
    }

    public void setCodigoDetalleHojaServicio_Repuesto(int codigoDetalleHojaServicio_Repuesto) {
        this.codigoDetalleHojaServicio_Repuesto = codigoDetalleHojaServicio_Repuesto;
    }

    public HojaServicio getHojaServicio_DetalleHojaServicio_Repuesto() {
        return hojaServicio_DetalleHojaServicio_Repuesto;
    }

    public void setHojaServicio_DetalleHojaServicio_Repuesto(HojaServicio hojaServicio_DetalleHojaServicio_Repuesto) {
        this.hojaServicio_DetalleHojaServicio_Repuesto = hojaServicio_DetalleHojaServicio_Repuesto;
    }

    public Repuesto getRepuesto_DetalleHojaServicio_Repuesto() {
        return repuesto_DetalleHojaServicio_Repuesto;
    }

    public void setRepuesto_DetalleHojaServicio_Repuesto(Repuesto repuesto_DetalleHojaServicio_Repuesto) {
        this.repuesto_DetalleHojaServicio_Repuesto = repuesto_DetalleHojaServicio_Repuesto;
    }

    public int getCantidad_DetalleHojaServicio_Repuesto() {
        return cantidad_DetalleHojaServicio_Repuesto;
    }

    public void setCantidad_DetalleHojaServicio_Repuesto(int cantidad_DetalleHojaServicio_Repuesto) {
        this.cantidad_DetalleHojaServicio_Repuesto = cantidad_DetalleHojaServicio_Repuesto;
    }

    public double getSubtotal_DetalleHojaServicio_Repuesto() {
        return subtotal_DetalleHojaServicio_Repuesto;
    }

    public void setSubtotal_DetalleHojaServicio_Repuesto(double subtotal_DetalleHojaServicio_Repuesto) {
        this.subtotal_DetalleHojaServicio_Repuesto = subtotal_DetalleHojaServicio_Repuesto;
    }
    
    
}
