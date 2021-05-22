/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.controller;

import com.gym.bean.Usuario;
import com.gym.repo.impl.UsuarioImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Usuario
 */
public class UsuarioController extends HttpServlet {

    String validaciones = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proceso = request.getParameter("txtProceso");

        switch (proceso) {

            case "login":
                login(request, response);
                break;

            case "nuevo":
                registro(request, response);
                break;

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("txtCorreo");
        String clave = DigestUtils.md5Hex(request.getParameter("txtClave"));
        System.out.println("CORREO " + correo);
        System.out.println("CLAVE " + clave);
        UsuarioImpl usuarioDAO = new UsuarioImpl();
        Usuario usuario = usuarioDAO.login(correo, clave);
        if (usuario != null && usuario.getTipouser().equals("admin")) {
            //request.getRequestDispatcher("admin.jsp").forward(request, response);
            // request.getRequestDispatcher("citacontroller.do?txtProceso=mostrar").forward(request, response);
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('BIENVENIDO!','Siempre atentos para su comodidad','success')");
            //response.getWriter().println("setTimeout(function(){ location='admin.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            //request.getSession().setAttribute("tipoUsuario",cu.tipoUsuario(usuario,contraseña));

            request.getSession().setAttribute("tipoUsuario", usuario.getTipouser());
            request.getSession().setAttribute("userName", correo);
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.include(request, response);
        } else if (usuario != null && usuario.getTipouser().equals("user")) {
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('BIENVENIDO!','Siempre atentos para su comodidad','success')");
            //response.getWriter().println("setTimeout(function(){ location='admin_user.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");

            request.getSession().setAttribute("tipoUsuario", usuario.getTipouser());
            request.getSession().setAttribute("userName", correo);
            RequestDispatcher rd = request.getRequestDispatcher("admin_user.jsp");
            rd.include(request, response);
        } else {
//            validaciones = "";
//            validaciones = "Usuario no Existe o Inactivo / Usuario o password incorrectos";
//            request.setAttribute("validaciones", validaciones);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('Error!','LOS DATOS INGRESADOS SON INCORRECTOS','error')");
            response.getWriter().println("setTimeout(function(){ location='index.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }
    }

    private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("email");
        String clave = DigestUtils.md5Hex(request.getParameter("password"));
        String clave2 = DigestUtils.md5Hex(request.getParameter("password2"));
        System.out.println("CORREO " + correo);
        System.out.println("CLAVE " + clave);
        int flag = 1;
        //Validamos que las claves ingresadas sean iguales
        if (!clave.equals(clave2)) {
            flag = 2;
             response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('Registro Errado!','Las contrasenas no son iguales','error')");
            response.getWriter().println("setTimeout(function(){ location='index.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            return;
        }
        
      

        Usuario usuario = new Usuario(correo, clave);

        UsuarioImpl usuarioDAO = new UsuarioImpl();
        // usuarioDAO.insert(t)correo, clave);
        int rpta = usuarioDAO.insertUser(usuario);
        if (rpta == 1 && flag == 1) {
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('Registro Creado!','Ahora puede acceder','success')");
            response.getWriter().println("setTimeout(function(){ location='index.jsp';},5000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        } 
        else if (rpta == 2) {
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('Registro Errado!','El correo no est&aacute asociado a un cliente inscrito','error')");
            response.getWriter().println("setTimeout(function(){ location='index.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        } else if (rpta == 3) {
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
            response.getWriter().println("<script>");
            response.getWriter().println("$(document).ready(function() {");
            response.getWriter().println("swal('Registro Errado!','El usuario ya existe','error')");
            response.getWriter().println("setTimeout(function(){ location='index.jsp';},2000);");
            response.getWriter().println("});");
            response.getWriter().println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }

    }

}
