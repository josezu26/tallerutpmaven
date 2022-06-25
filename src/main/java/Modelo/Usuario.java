package Modelo;

/**
 *
 * @author Jose
 */
public class Usuario {
    
    //Atributos
    private int codigoUsuario;
    private Persona persona;
    private String password;
    private TipoUsuario tipoUsuario;
    private EstadoUsuario estadoUsuario;
    
    //Constructor
    public Usuario(){}

    public Usuario(int codigoUsuario, Persona persona, String password, TipoUsuario tipoUsuario, EstadoUsuario estadoUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.persona = persona;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.estadoUsuario = estadoUsuario;
    }
    
    //Metodos Getter and Setter
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    
}
