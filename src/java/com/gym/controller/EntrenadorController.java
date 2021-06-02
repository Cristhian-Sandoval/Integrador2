/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.controller;

import com.google.gson.Gson;
import com.gym.bean.Cliente;
import com.gym.bean.Entrenador;
import com.gym.repo.impl.ClienteImpl;
import com.gym.repo.impl.EntrenadorImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class EntrenadorController extends HttpServlet {
        String validaciones = "";

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proceso = request.getParameter("txtProceso");

        switch (proceso) {

            case "mostrar":
                mostrar(request, response);
                break;
            case "registro":
                registrar(request, response);
                break;
            case "borrar":
                eliminar(request, response);
                break;
            case "mostrarID":
                mostrarID(request, response);
                break;
            case "editar":
                actualizar(request, response);
                break;    

        }
    }
    
     protected void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntrenadorImpl entrenadorDAO = new EntrenadorImpl();

        List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
        request.setAttribute("lista", listaEntrenador);
        request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("txtNombre");
        String apepat = request.getParameter("txtApepat");
        String apemat = request.getParameter("txtApemat");
        String correo = request.getParameter("txtCorreo");
        String dni = request.getParameter("txtDNI");
        String telefono = request.getParameter("txtTel");
        
        System.out.println(nombre  +  apepat + apemat + correo + dni +telefono);

        validaciones = "";

        Entrenador entrenador = new Entrenador(nombre,apepat,apemat,telefono,correo,dni);
        EntrenadorImpl entrenadorDAO = new EntrenadorImpl();


        if (entrenadorDAO.insert(entrenador)) {
            validaciones = "Se ha realizado el registro exitosamente";
            request.setAttribute("validaciones", validaciones);
            //request.getRequestDispatcher("cliente.jsp").forward(request, response);
             List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
        request.setAttribute("lista", listaEntrenador);
        request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
        } else {
            validaciones = "No se realizado el registro";
            request.setAttribute("validaciones", validaciones);
             List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
        request.setAttribute("lista", listaEntrenador);
        request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
          //  request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("INGRESA A ELIMINAR ID " + id);
        Entrenador cliente = new Entrenador(id);
        EntrenadorImpl entrenadorDAO = new EntrenadorImpl();

        if (entrenadorDAO.delete(cliente)) {
            List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
            request.setAttribute("lista", listaEntrenador);
            request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
        } else {
            List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
            request.setAttribute("lista", listaEntrenador);
            request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
        }
    }

    private void mostrarID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json");
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Entra a mostrar ID " + id);
        EntrenadorImpl entrenadorDAO = new EntrenadorImpl();
        Entrenador entrenador = entrenadorDAO.selectById(id);      
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(entrenador));
        writer.flush();
        writer.close();
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id")); 
        String nombre = request.getParameter("nombre");
        String apepat = request.getParameter("apepat");
        String apemat = request.getParameter("apemat");
        String fono = request.getParameter("fono");
        String correo = request.getParameter("email");
        String dni = request.getParameter("dni");
        String activo = request.getParameter("activo");
        
         boolean estado = true;
            
        if (activo==null){
            estado=false;
        }
  
        validaciones = "";
        
        Entrenador entrenador = new Entrenador(id,nombre,apepat,apemat,fono,correo,dni,estado);
        EntrenadorImpl entrenadorDAO = new EntrenadorImpl();

        
        if (entrenadorDAO.update(entrenador)) {
            validaciones = "Se ha realizado la actualización exitosamente";
            request.setAttribute("validaciones", validaciones);
             //response.sendRedirect("lista_clientes.jsp");
          

        List<Entrenador> listaEntrenador = entrenadorDAO.selectAll();
        request.setAttribute("lista", listaEntrenador);
        request.getRequestDispatcher("lista_entrenador.jsp").forward(request, response);
           // request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        } else {
            validaciones = "No se realizado la actualización";
            request.setAttribute("validaciones", validaciones);
               response.sendRedirect("lista_entrenador.jsp");
            //request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        }
    }
}
