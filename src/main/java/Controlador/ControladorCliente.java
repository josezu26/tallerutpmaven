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
@WebServlet(name = "ControladorCliente", urlPatterns = {"/ControladorCliente"})
public class ControladorCliente extends HttpServlet {

    EquipoDAO equipoDAO = new EquipoDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    HojaServicioDAO hojaServicioDAO = new HojaServicioDAO();
    ServicioDAO servicioDAO = new ServicioDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
    
    List<Servicio> carritoServicios = new ArrayList<>();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        
        switch(accion){
            
            case "formularioNuevaSolicitud1":
                int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                Usuario usuario = usuarioDAO.obtenerUsuario(codigoCliente);
                List<MarcaEquipo> listaMarcas = equipoDAO.listarMarcasEquipo();
                List<Usuario> listaTecnicos = tecnicoDAO.listarTecnicos();
                List<TipoEquipo> listaTipos = equipoDAO.listarTiposEquipo();
                List<Servicio> listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaMarcas", listaMarcas);
                sesion.setAttribute("listaTecnicos", listaTecnicos);
                sesion.setAttribute("listaTipos", listaTipos);
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("listaServicios", listaServicios);
                
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio1.jsp").forward(request, response);
                
                break;
                
            //PROCESO HOJAS SERVICIO
            case "formularioNuevaSolicitud":
                codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                List<Equipo> listaequipocliente = equipoDAO.listarEquipoCliente(codigoCliente);
                
                sesion.setAttribute("listaequipocliente", listaequipocliente);
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio1.jsp").forward(request, response);
                break;
                
            case "seleccionarEquipo":
                int codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                listaServicios = servicioDAO.listarServicios();
                carritoServicios.clear();
                
                sesion.setAttribute("codigoEquipo", codigoEquipo);
                sesion.setAttribute("listaServicios", listaServicios);
                sesion.setAttribute("carritoServicios", carritoServicios);
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio2.jsp").forward(request, response);
                break;
                
            case "agregarServicioCarrito":
                int codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicioAgregado = servicioDAO.obtenerServicio(codigoServicio);
                carritoServicios.add(servicioAgregado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio2.jsp").forward(request, response);
                
                break;
                
            case "eliminarServicioCarrito":
                codigoServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                Servicio servicioEliminado = servicioDAO.obtenerServicio(codigoServicio);
                for(Servicio i : carritoServicios){
                    if(i.getCodigoServicio() == servicioEliminado.getCodigoServicio()){
                        servicioEliminado = i;
                    }
                }
                
                carritoServicios.remove(servicioEliminado);
                listaServicios = servicioDAO.listarServicios();
                
                sesion.setAttribute("listaServicios", listaServicios);
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio2.jsp").forward(request, response);
                
                break;
                
                
            case "Continuar":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                listaTecnicos = tecnicoDAO.listarTecnicos();
                
                sesion.setAttribute("carritoServicios", carritoServicios);
                sesion.setAttribute("codigoEquipo", codigoEquipo);
                sesion.setAttribute("listaTecnicos", listaTecnicos);
                request.getRequestDispatcher("./hojaServicioCliente/procesoServicio3.jsp").forward(request, response);
            break;
                
            case "ingresarSolicitud":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                int codigoTecnico = Integer.parseInt(request.getParameter("codigoTecnico"));
                String descripcionProblema = request.getParameter("descripcionProblema");
                int codigoEstado = 1;
                double total = 0.00;
                String fechaHojaServicio = request.getParameter("fechaHojaServicio");
                String horaHojaServicio = request.getParameter("horaHojaServicio");
                
                
                Equipo equipo = equipoDAO.obtenerEquipo(codigoEquipo);
                Usuario tecnico = usuarioDAO.obtenerUsuario(codigoTecnico);
                hojaServicioDAO.registrarHojaServicio(tecnico.getCodigoUsuario(), equipo.getCodigoEquipo(), 
                descripcionProblema, total, fechaHojaServicio, horaHojaServicio, codigoEstado, carritoServicios);
                
                request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
                break;
//P.4 CRUD EQUIPOS        
            //AÑADIR
            case "formularioNuevoEquipo":
                codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                usuario = usuarioDAO.obtenerUsuario(codigoCliente);
                listaMarcas = equipoDAO.listarMarcasEquipo();
                listaTipos = equipoDAO.listarTiposEquipo();
                sesion.setAttribute("listaMarcas", listaMarcas);
                sesion.setAttribute("listaTipos", listaTipos);
                sesion.setAttribute("usuario", usuario);
                
                request.getRequestDispatcher("agregarEquipo.jsp").forward(request, response);
                
                break;                
                
            case "agregarEquipo":
                int codigoMarcaEquipo = Integer.parseInt(request.getParameter("codigoMarca"));
                int codigoTipoEquipo = Integer.parseInt(request.getParameter("codigoTipo"));
                codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                usuario = usuarioDAO.obtenerUsuario(codigoCliente);
                String descripcionEquipo = request.getParameter("descripcionEquipo");
                equipoDAO.registrarEquipo(codigoMarcaEquipo, codigoTipoEquipo, codigoCliente, descripcionEquipo);
                
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
            break;
            //ACTUALIZAR
            case "formularioActualizarEquipo":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                equipo = equipoDAO.obtenerEquipo(codigoEquipo);
                listaMarcas = equipoDAO.listarMarcasEquipo();
                listaTipos = equipoDAO.listarTiposEquipo();
                sesion.setAttribute("listaMarcas", listaMarcas);
                sesion.setAttribute("listaTipos", listaTipos);
                sesion.setAttribute("equipo", equipo);
                
                request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
            break;
            
            case "actualizarEquipo":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                int codigoMarca = Integer.parseInt(request.getParameter("codigoMarca"));
                int codigoTipo = Integer.parseInt(request.getParameter("codigoTipo"));
                int codigoEquipoUsuario= Integer.parseInt(request.getParameter("codigoUsuarioEquipo"));
                descripcionEquipo = request.getParameter("descripcionEquipo");
                
                usuario = usuarioDAO.obtenerUsuario(codigoEquipoUsuario);
                equipoDAO.actualizarEquipo(codigoEquipo, codigoMarca, codigoTipo, descripcionEquipo);
                
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
            break;
            //ELIMINAR
            case "eliminarEquipo":
                codigoEquipo = Integer.parseInt(request.getParameter("codigoEquipo"));
                equipo = equipoDAO.obtenerEquipo(codigoEquipo);
                usuario = usuarioDAO.obtenerUsuario(equipo.getUsuarioEquipo().getCodigoUsuario());
                equipoDAO.eliminarEquipo(codigoEquipo);
                
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
            break;
                
//P.4 Listar Equipos por Cliente
            case "listarEquipoCliente":
                codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                listaequipocliente = equipoDAO.listarEquipoCliente(codigoCliente);
                
                sesion.setAttribute("listaequipocliente", listaequipocliente);
                request.getRequestDispatcher("listarEquipos.jsp").forward(request, response);
            break;
            
            case "listarHojaServicio":
                int codigousuario = Integer.parseInt(request.getParameter("codigoCliente"));
                
                List<HojaServicio> listaHojaServicio = hojaServicioDAO.listarHojaServicioCliente(1, codigousuario);
                
                sesion.setAttribute("listaHojaServicio", listaHojaServicio);
                
                request.getRequestDispatcher("listarHojaServicio.jsp").forward(request, response);
                break;
                
            
        }
        
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
