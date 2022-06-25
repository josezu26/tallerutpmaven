package Modelo;

public class CarritoRepuesto {
    
    //ATRIBUTOS
    private Repuesto repuesto;
    private int cantidad;
    
    //CONSTRUCTORES
    public CarritoRepuesto(Repuesto repuesto, int cantidad) {
        this.repuesto = repuesto;
        this.cantidad = cantidad;
    }
    public CarritoRepuesto(){}
    
    //METODOS GETTER && SETTER

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
