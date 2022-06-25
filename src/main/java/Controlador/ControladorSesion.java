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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jose
 */
@WebServlet(name = "ControladorSesion", urlPatterns = {"/ControladorSesion"})
public class ControladorSesion extends HttpServlet {

    SesionDAO sesionDAO = new SesionDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorSesion at " + request.getContextPath() + "</h1>");
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        HttpSession sesion = request.getSession();
        switch(accion){
            case "ingresar":
                
                String user = request.getParameter("usuario");
                int coduser = Integer.parseInt(user);
                String pass = request.getParameter("password");
                
                int codigoUsuario = sesionDAO.iniciarSesion(coduser, pass);
                Usuario usuario = usuarioDAO.obtenerUsuario(codigoUsuario);
                
                
                sesion.setAttribute("usuario", usuario);
                
                switch(usuario.getTipoUsuario().getCodigoTipoUsuario()){
                    
                    case 1:
                        request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
                        break;
                    case 2:
                        request.getRequestDispatcher("inicioTecnico.jsp").forward(request, response);
                        break;
                    case 3:
                        request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);
                        break;
                    default:
                        
                        request.getRequestDispatcher("loginfail.jsp").forward(request, response);
                    break;
                }
                break;
            case "cerrarSesion":
                sesion.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                
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
                
                sesionDAO.registrarDireccion(direccion, codigoDistrito);
                int codigoDireccion = sesionDAO.obtenerCodigoDireccion(direccion);
                sesionDAO.registrarPersona(codigoPersona, nombre, apellidoPaterno, apellidoMaterno, codigoDireccion, 0, telefono, correo);
                sesionDAO.registrarUsuario(codigoPersona, password, 1, 0);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
