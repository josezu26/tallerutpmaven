package Modelo;

public class Equipo {
    
    //ATRIBUTOS
    private int codigoEquipo;
    private MarcaEquipo marcaEquipo;
    private TipoEquipo tipoEquipo;
    private Usuario usuarioEquipo;
    private String descripcionEquipo;
    
    //CONSTRUCTOR
    public Equipo(){}
    
    public Equipo(int codigoEquipo, MarcaEquipo marcaEquipo, TipoEquipo tipoEquipo, Usuario usuarioEquipo, String descripcionEquipo) {
        this.codigoEquipo = codigoEquipo;
        this.marcaEquipo = marcaEquipo;
        this.tipoEquipo = tipoEquipo;
        this.usuarioEquipo = usuarioEquipo;
        this.descripcionEquipo = descripcionEquipo;
    }
    
    //METODOS GETTER AND SETTER
    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public MarcaEquipo getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(MarcaEquipo marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Usuario getUsuarioEquipo() {
        return usuarioEquipo;
    }

    public void setUsuarioEquipo(Usuario usuarioEquipo) {
        this.usuarioEquipo = usuarioEquipo;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }
    
    
    
}
