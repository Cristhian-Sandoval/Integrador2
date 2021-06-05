/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.controller;

import com.google.gson.Gson;
import com.gym.bean.Sala;
import com.gym.repo.impl.SalaImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class SalaController  extends HttpServlet{
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

        SalaImpl salaDAO  = new SalaImpl();

        List<Sala> listaSalas = salaDAO.selectAll();
        request.setAttribute("lista", listaSalas);
        request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String descripcion = request.getParameter("txtNombre");
        int aforo = Integer.parseInt(request.getParameter("txtAforo"));

        
        System.out.println(descripcion  +  aforo  );

        validaciones = "";

        Sala sala = new Sala(descripcion,aforo);
        SalaImpl salaDAO = new SalaImpl();


        if (salaDAO.insert(sala)) {
            validaciones = "Se ha realizado el registro exitosamente";
            request.setAttribute("validaciones", validaciones);
            //request.getRequestDispatcher("cliente.jsp").forward(request, response);
             List<Sala> listaSala = salaDAO.selectAll();
        request.setAttribute("lista", listaSala);
        request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
        } else {
            validaciones = "No se realizado el registro";
            request.setAttribute("validaciones", validaciones);
             List<Sala> listaSala = salaDAO.selectAll();
        request.setAttribute("lista", listaSala);
        request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
          //  request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("INGRESA A ELIMINAR ID " + id);
        Sala sala = new Sala(id);
        SalaImpl salaDAO = new SalaImpl();

        if (salaDAO.delete(sala)) {
            List<Sala> listaSala = salaDAO.selectAll();
            request.setAttribute("lista", listaSala);
            request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
        } else {
            List<Sala> listaSala = salaDAO.selectAll();
            request.setAttribute("lista", listaSala);
            request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
        }
    }

    private void mostrarID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json");
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Entra a mostrar ID " + id);
        SalaImpl salaDAO = new SalaImpl();
        Sala sala = salaDAO.selectById(id);      
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(sala));
        writer.flush();
        writer.close();
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id")); 
        String descripcion = request.getParameter("descripcion");
        int aforo = Integer.parseInt(request.getParameter("aforo"));

        String activo = request.getParameter("activo");
        
         boolean estado = true;
            
        if (activo==null){
            estado=false;
        }
  
        validaciones = "";
        
        Sala sala = new Sala(id,descripcion,aforo,estado);
        SalaImpl salaDAO = new SalaImpl();

        
        if (salaDAO.update(sala)) {
            validaciones = "Se ha realizado la actualización exitosamente";
            request.setAttribute("validaciones", validaciones);
             //response.sendRedirect("lista_clientes.jsp");
          

        List<Sala> listaSala = salaDAO.selectAll();
        request.setAttribute("lista", listaSala);
        request.getRequestDispatcher("lista_salas.jsp").forward(request, response);
           // request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        } else {
            validaciones = "No se realizado la actualización";
            request.setAttribute("validaciones", validaciones);
               response.sendRedirect("lista_salas.jsp");
            //request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        }
    }
}
