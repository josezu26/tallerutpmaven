package Modelo;

/**
 *
 * @author Jose
 */
public class EstadoUsuario {
    
    //Atributos
    private int codigoEstadoUsuario;
    private String descripcionEstadoUsuario;
    
    //Constructor
    public EstadoUsuario(){}

    public EstadoUsuario(int codigoEstadoUsuario, String descripcionEstadoUsuario) {
        this.codigoEstadoUsuario = codigoEstadoUsuario;
        this.descripcionEstadoUsuario = descripcionEstadoUsuario;
    }
    
    //Metodos Getter and Setter
    public int getCodigoEstadoUsuario() {
        return codigoEstadoUsuario;
    }

    public void setCodigoEstadoUsuario(int codigoEstadoUsuario) {
        this.codigoEstadoUsuario = codigoEstadoUsuario;
    }

    public String getDescripcionEstadoUsuario() {
        return descripcionEstadoUsuario;
    }

    public void setDescripcionEstadoUsuario(String descripcionEstadoUsuario) {
        this.descripcionEstadoUsuario = descripcionEstadoUsuario;
    }
    
}
