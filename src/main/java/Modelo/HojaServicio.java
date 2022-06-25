package Modelo;

public class HojaServicio {
    
    //ATRIBUTOS
    private int codigoHojaServicio;
    private Usuario TecnicoHojaServicio;
    private Equipo equipoHojaServicio;
    private String descripcionHojaServicio;
    private double precioVisita;
    private String fechaHojaServicio;
    private String horaHojaServicio;
    private EstadoHojaServicio estadoHojaServicio;
    private double total;
    
    //CONSTRUCTOR
    public HojaServicio(){}
    
    public HojaServicio(int codigoHojaServicio, Usuario TecnicoHojaServicio, Equipo equipoHojaServicio, String descripcionHojaServicio, double precioVisita, String fechaHojaServicio, String horaHojaServicio, EstadoHojaServicio estadoHojaServicio, double total) {
        this.codigoHojaServicio = codigoHojaServicio;
        this.TecnicoHojaServicio = TecnicoHojaServicio;
        this.equipoHojaServicio = equipoHojaServicio;
        this.descripcionHojaServicio = descripcionHojaServicio;
        this.precioVisita = precioVisita;
        this.fechaHojaServicio = fechaHojaServicio;
        this.horaHojaServicio = horaHojaServicio;
        this.estadoHojaServicio = estadoHojaServicio;
        this.total = total;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoHojaServicio() {
        return codigoHojaServicio;
    }

    public void setCodigoHojaServicio(int codigoHojaServicio) {
        this.codigoHojaServicio = codigoHojaServicio;
    }

    public Usuario getTecnicoHojaServicio() {
        return TecnicoHojaServicio;
    }

    public void setTecnicoHojaServicio(Usuario TecnicoHojaServicio) {
        this.TecnicoHojaServicio = TecnicoHojaServicio;
    }

    public Equipo getEquipoHojaServicio() {
        return equipoHojaServicio;
    }

    public void setEquipoHojaServicio(Equipo equipoHojaServicio) {
        this.equipoHojaServicio = equipoHojaServicio;
    }

    public String getDescripcionHojaServicio() {
        return descripcionHojaServicio;
    }

    public void setDescripcionHojaServicio(String descripcionHojaServicio) {
        this.descripcionHojaServicio = descripcionHojaServicio;
    }

    public double getPrecioVisita() {
        return precioVisita;
    }

    public void setPrecioVisita(double precioVisita) {
        this.precioVisita = precioVisita;
    }

    public String getFechaHojaServicio() {
        return fechaHojaServicio;
    }

    public void setFechaHojaServicio(String fechaHojaServicio) {
        this.fechaHojaServicio = fechaHojaServicio;
    }

    public String getHoraHojaServicio() {
        return horaHojaServicio;
    }

    public void setHoraHojaServicio(String horaHojaServicio) {
        this.horaHojaServicio = horaHojaServicio;
    }

    public EstadoHojaServicio getEstadoHojaServicio() {
        return estadoHojaServicio;
    }

    public void setEstadoHojaServicio(EstadoHojaServicio estadoHojaServicio) {
        this.estadoHojaServicio = estadoHojaServicio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
