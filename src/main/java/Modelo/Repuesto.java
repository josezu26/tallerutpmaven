package Modelo;

/**
 *
 * @author Jose
 */
public class Repuesto {
    
    //ATRIBUTOS
    private int codigoRepuesto;
    private String nombreRepuesto;
    private String descripcionRepuesto;
    private double precioRepuesto;
    private int stockRepuesto;
    
    //CONTRUCTOR
    public Repuesto(){}

    public Repuesto(int codigoRepuesto, String nombreRepuesto, String descripcionRepuesto, double precioRepuesto, int stockRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precioRepuesto = precioRepuesto;
        this.stockRepuesto = stockRepuesto;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(int codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public double getPrecioRepuesto() {
        return precioRepuesto;
    }

    public void setPrecioRepuesto(double precioRepuesto) {
        this.precioRepuesto = precioRepuesto;
    }

    public int getStockRepuesto() {
        return stockRepuesto;
    }

    public void setStockRepuesto(int stockRepuesto) {
        this.stockRepuesto = stockRepuesto;
    }
    
}
