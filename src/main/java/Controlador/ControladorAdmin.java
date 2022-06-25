/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.*;
import DAO.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jose
 */
@WebServlet(name = "ControladorAdmin", urlPatterns = {"/ControladorAdmin"})
public class ControladorAdmin extends HttpServlet {

    SesionDAO sesionDAO = new SesionDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    RepuestoDAO repuestoDAO = new RepuestoDAO();
    ServicioDAO servicioDAO = new ServicioDAO();
    HojaServicioDAO hojaServicioDAO = new HojaServicioDAO();
    int codigoTecnico = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    List<Repuesto> carritoRepuestos = new ArrayList<>();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        Usuario usuario = new Usuario();
        
        switch(accion){
            case "registrar":
                int codigoPersona = Integer.parseInt(request.getParameter("codigoPersona"));
                String password = request.getParameter("password");
                String nombre = request.getParameter("nombre");
                String apellidoPaterno = request.getParameter("apellidoPaterno");
                String apellidoMaterno = request.getParameter("apellidoMaterno");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String direccion = request.getParameter("direccion");
                int codigoDistrito = Integer.parseInt(request.getParameter("distrito"));
                int codigoEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
                
                sesionDAO.registrarDireccion(direccion, codigoDistrito);
                int codigoDireccion = sesionDAO.obtenerCodigoDireccion(direccion);
                sesionDAO.registrarPersona(codigoPersona, nombre, apellidoPaterno, apellidoMaterno, codigoDireccion, codigoEspecialidad, telefono, correo);
                sesionDAO.registrarUsuario(codigoPersona, password, 2, 1);
                request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);
                break;
                
            case "listarTecnicos":
                
                List<Usuario> listaTecnicos = tecnicoDAO.listarTecnicos();
                
                sesion.setAttribute("listaTecnicos", listaTecnicos);
                request.getRequestDispatcher("listarTecnicos.jsp").forward(request, response);
                break;
                
            case "modificar":
                
                codigoTecnico = Integer.parseInt(request.getParameter("codigo"));
                
                usuario = usuarioDAO.obtenerUsuario(codigoTecnico);
                
                sesion.setAttribute("usuario", usuario);
                
                request.getRequestDispatcher("actualizarTecnico.jsp").forward(request, response);
                break;
                
            case "actualizar":
                
                int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
                codigoPersona = Integer.parseInt(request.getParameter("codigoPersona"));
                password = request.getParameter("password");
                nombre = request.getParameter("nombre");
                apellidoPaterno = request.getParameter("apellidoPaterno");
                apellidoMaterno = request.getParameter("apellidoMaterno");
                telefono = request.getParameter("telefono");
                correo = request.getParameter("correo");
                direccion = request.getParameter("direccion");
                codigoDistrito = Integer.parseInt(request.getParameter("distrito"));
                codigoEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
                
                usuario = usuarioDAO.obtenerUsuario(codigoUsuario);
                codigoDireccion = usuario.getPersona().getDireccion().getCodigoDireccion();
                
                String descripcionDireccion = direccion.toString();
                
                tecnicoDAO.actualizarDireccionTecnico(codigoDireccion, descripcionDireccion, codigoDistrito);
                tecnicoDAO.actualizarPersonaTecnico(codigoPersona, nombre, apellidoPaterno, apellidoMaterno, codigoEspecialidad, telefono, correo);
                tecnicoDAO.actualizarUsuarioTecnico(usuario.getCodigoUsuario(), password);
                
                request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);
                
                break;
                
            case "eliminarTecnico":
                
                codigoTecnico = Integer.parseInt(request.getParameter("codigo"));
                tecnicoDAO.eliminarUsuario(codigoTecnico);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarTecnicos").forward(request, response);
                break;
                
            case "agregarRepuesto":
                
                String nombreRepuesto = request.getParameter("nombreRepuesto");
                String descripcionRepuesto = request.getParameter("descripcionRepuesto");
                double precioRepuesto = Double.parseDouble(request.getParameter("precioRepuesto"));
                int stcokRepuesto = Integer.parseInt(request.getParameter("stockRepuesto"));
                
                repuestoDAO.registrarRepuesto(nombreRepuesto, descripcionRepuesto, precioRepuesto, stcokRepuesto);
                
                request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);
                break;
                
            case "listarRepuestos":
                
                List<Repuesto> listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                request.getRequestDispatcher("listarRepuestos.jsp").forward(request, response);
                
                break;
                
            case "modificarRepuesto":
                
                int codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuesto = new Repuesto();
                repuesto = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                
                sesion.setAttribute("repuesto", repuesto);
                request.getRequestDispatcher("actualizarRepuesto.jsp").forward(request, response);
                break;
                
            case "actualizarRepuesto":
                
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                nombreRepuesto = request.getParameter("nombreRepuesto");
                descripcionRepuesto = request.getParameter("descripcionRepuesto");
                precioRepuesto = Double.parseDouble(request.getParameter("precioRepuesto"));
                stcokRepuesto = Integer.parseInt(request.getParameter("stockRepuesto"));
                
                repuestoDAO.actualizarRepuesto(codigoRepuesto, nombreRepuesto, descripcionRepuesto, precioRepuesto, stcokRepuesto);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarRepuestos").forward(request, response);
                break;
                
            case "eliminarRepuesto":
                
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                
                repuestoDAO.eliminarRepuesto(codigoRepuesto);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarRepuestos").forward(request, response);
                break;
                
            case "listarHojasServicio":
                int estadoHojaServicio = Integer.parseInt(request.getParameter("estadoHojaServicio"));
                List<HojaServicio> listaHojaServicio = hojaServicioDAO.listarHojaServicio(estadoHojaServicio);
                
                sesion.setAttribute("listaHojaServicio", listaHojaServicio);
                
                request.getRequestDispatcher("listarHojaServicioAdmin.jsp").forward(request, response);
                break;
                
            case "agregarCantidad":
                codigoRepuesto = Integer.parseInt(request.getParameter("codigo"));
                Repuesto repuestoSeleccionado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                int codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                
                sesion.setAttribute("repuestoSeleccionado", repuestoSeleccionado);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("agregarCantidad.jsp").forward(request, response);
                break;
            
            case "Agregar":
                
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                repuesto = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                HojaServicio hojaServicio = hojaServicioDAO.obtenerHojaServicio(codigoHojaServicio);
                double subtotal = repuesto.getPrecioRepuesto() * cantidad;
                repuestoDAO.ingresarHojaServicioRepuesto(hojaServicio.getCodigoHojaServicio(), 
                        repuesto.getCodigoRepuesto(), cantidad, subtotal);
                subtotal = hojaServicio.getTotal() + subtotal;
                hojaServicioDAO.actualizarTotal(hojaServicio.getCodigoHojaServicio(), subtotal);
                
                request.setAttribute("codigoHojaServicio", hojaServicio.getCodigoHojaServicio());
                request.getRequestDispatcher("ControladorAdmin?accion=procesar").forward(request, response);
                
                break;
            /*    
            case "procesar1":
                listaRepuestos = repuestoDAO.listarRepuestos();
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));

                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("procesarHojaServicio.jsp").forward(request, response);
                
                break;
                
            case "procesar":
                listaRepuestos = repuestoDAO.listarRepuestos();
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));

                sesion.setAttribute("listaRepuestos", listaRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("seleccionarRepuesto.jsp").forward(request, response);
                
                break;
            */
            case "procesar":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("procesarHojaServicio.jsp").forward(request, response);
                break;
            case "agregarRepuestoCarrito":
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoAgregado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                carritoRepuestos.add(repuestoAgregado);
                listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                request.getRequestDispatcher("seleccionarRepuesto.jsp").forward(request, response);
                break;
                
            case "eliminarRepuestoCarrito":
                codigoRepuesto = Integer.parseInt(request.getParameter("codigoRepuesto"));
                Repuesto repuestoEliminado = repuestoDAO.obtenerRepuesto(codigoRepuesto);
                for(Repuesto i : carritoRepuestos){
                    if(i.getCodigoRepuesto() == repuestoEliminado.getCodigoRepuesto()){
                        repuestoEliminado = i;
                    }
                }
                
                carritoRepuestos.remove(repuestoEliminado);
                listaRepuestos = repuestoDAO.listarRepuestos();
                
                sesion.setAttribute("listaRepuestos", listaRepuestos);
                request.getRequestDispatcher("seleccionarRepuesto.jsp").forward(request, response);
                break;
                
            case "Continuar":
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                
                sesion.setAttribute("carritoRepuestos", carritoRepuestos);
                sesion.setAttribute("codigoHojaServicio", codigoHojaServicio);
                request.getRequestDispatcher("procesarHojaServicio.jsp").forward(request, response);
                break;
            /*    
            case "Finalizar":
                double precioVisita = Double.parseDouble(request.getParameter("precioVisita"));
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                double precioRepuestos = 0;
                hojaServicio = hojaServicioDAO.obtenerHojaServicio(codigoHojaServicio);
                
                for(Repuesto i : carritoRepuestos){
                    precioRepuestos = precioRepuestos + i.getPrecioRepuesto();
                }
                carritoRepuestos.clear();
                double totalFinal = precioVisita + hojaServicio.getTotal() + precioRepuestos;
                hojaServicioDAO.asignarPresupuesto(hojaServicio.getCodigoHojaServicio(), 
                        precioVisita, totalFinal, 2);
               
                request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);  
                break;
            */
            case "Verificar":
                String fechaHojaServicioFinal = request.getParameter("fechaHojaServicio");
                String horaHojaServicioFinal = request.getParameter("horaHojaServicio");
                codigoHojaServicio = Integer.parseInt(request.getParameter("codigoHojaServicio"));
                
                hojaServicioDAO.verificarFechaHora(codigoHojaServicio, fechaHojaServicioFinal, horaHojaServicioFinal, 2);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarHojasServicio&estadoHojaServicio=1").forward(request, response);
                break;
                
            case "Filtrar":
                int codigoEstado = Integer.parseInt(request.getParameter("codigoEstado"));
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarHojasServicio&estadoHojaServicio="+codigoEstado).forward(request, response);
                break;

            //P.5 CRUD SERVICIOS    
            case "listarServicios":
                List<Servicio> listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("listarServicios.jsp").forward(request, response);
            break;
            
            case "modificarServicio":
                int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicio = new Servicio();
                servicio = servicioDAO.obtenerServicio(codigoServicio);
                
                sesion.setAttribute("servicio", servicio);
                request.getRequestDispatcher("actualizarServicio.jsp").forward(request, response);
            break;
            case "agregarServicio":
                String nombreServicio = request.getParameter("nombreServicio");
                double precioServicio = Double.parseDouble(request.getParameter("precioServicio")); 
                String descripcionServicio = request.getParameter("descripcionServicio");
                
                servicioDAO.agregarServicio(nombreServicio, precioServicio, descripcionServicio);
                request.getRequestDispatcher("ControladorAdmin?accion=listarServicios").forward(request, response);
            break;
            case "actualizarServicio":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                nombreServicio = request.getParameter("nombreServicio");
                precioServicio = Double.parseDouble(request.getParameter("precioServicio"));
                descripcionServicio = request.getParameter("descripcionServicio");
                
                servicioDAO.actualizarServicio(codigoServicio, nombreServicio, precioServicio,descripcionServicio);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarServicios").forward(request, response);
            break;
            case "eliminarServicio":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                
                servicioDAO.eliminarServicio(codigoServicio);
                
                request.getRequestDispatcher("ControladorAdmin?accion=listarServicios").forward(request, response);
            break;
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
