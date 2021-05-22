/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.controller;

import com.gym.bean.Cliente;
import com.gym.bean.Hora;
import com.gym.bean.Reserva;
import com.gym.bean.Sala;
import com.gym.repo.impl.ReservaImpl;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ReservaController extends HttpServlet {

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
                mostrardato(request, response);
                break;
            case "registro":
                registrar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
        }
    }

    protected void mostrardato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("correo");
        System.out.println("Correo " + correo);
        ReservaImpl reservaDAO = new ReservaImpl();
        List<Hora> listaHoras = reservaDAO.listarHoras();
        List<Sala> listaSalas = reservaDAO.listarSalas();
        Cliente cliente = reservaDAO.mostrarIdCliente(correo);

        request.setAttribute("listaHora", listaHoras);
        request.setAttribute("listaSalas", listaSalas);
        request.setAttribute("idCliente", cliente.getId());
        request.getRequestDispatcher("nueva_reserva.jsp").forward(request, response);

//        ClienteImpl clienteDAO = new ClienteImpl();
//
//        List<Cliente> listaCliente = clienteDAO.selectAll();
//        request.setAttribute("lista", listaCliente);
//        request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("txtidCliente"));
        int salat = Integer.parseInt(request.getParameter("txtSala"));
        String fecha = request.getParameter("txtFecha");
        int hora = Integer.parseInt(request.getParameter("txtHora"));
        System.out.println("Fecha " + fecha);
        System.out.println("Hora " + hora);

        validaciones = "";

        Reserva reserva = new Reserva();
        reserva.setFecha(fecha);
        
        Hora horas = new Hora();
        horas.setIdHora(hora);
         
        reserva.setHora(horas);

        Cliente cliente = new Cliente(id);
        Sala sala = new Sala(salat);

        reserva.setIdcliente(cliente);
        reserva.setIdsala(sala);

        ReservaImpl reservaDAO = new ReservaImpl();

        int resultado = reservaDAO.insertReserva(reserva);

        if (resultado == 1) {
            validaciones = "CLIENTE YA CUENTA CON UNA RESERVA EN EL DIA";
            request.setAttribute("validaciones", validaciones);
            //request.getRequestDispatcher("nueva_reserva.jsp").forward(request, response);
//            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
//            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
//            response.getWriter().println("<script>");
//            response.getWriter().println("$(document).ready(function() {");
//            response.getWriter().println("swal('CLIENTE YA CUENTA CON UNA RESERVA EN EL DIA')");
//            response.getWriter().println("setTimeout(function(){ location='admin_user.jsp';},2000);");
//            response.getWriter().println("});");
//            response.getWriter().println("</script>");
            mostrardato(request, response);
        } else if (resultado == 2) {
            validaciones = "AFORO COMPLETADO PARA LA SALA A RESERVAR";
            request.setAttribute("validaciones", validaciones);
            //request.getRequestDispatcher("nueva_reserva.jsp").forward(request, response);
//             response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//            response.getWriter().println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css'>");
//            response.getWriter().println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js'></script>");
//            response.getWriter().println("<script>");
//            response.getWriter().println("$(document).ready(function() {");
//            response.getWriter().println("swal('AFORO COMPLETADO PARA LA SALA A RESERVAR')");
//            response.getWriter().println("setTimeout(function(){ location='admin_user.jsp';},2000);");
//            response.getWriter().println("});");
//            response.getWriter().println("</script>");
            mostrardato(request, response);

        } else if (resultado == 0) {
            listar(request, response);
         
        }

//        Cliente cliente = new Cliente(nombre, apepat, apemat, correo, dni, telefono);
//        ClienteImpl clienteDAO = new ClienteImpl();
//        if (clienteDAO.insert(cliente)) {
//            validaciones = "Se ha realizado el registro exitosamente";
//            request.setAttribute("validaciones", validaciones);
//            //request.getRequestDispatcher("cliente.jsp").forward(request, response);
//             List<Cliente> listaCliente = clienteDAO.selectAll();
//        request.setAttribute("lista", listaCliente);
//        request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
//        } else {
//            validaciones = "No se realizado el registro";
//            request.setAttribute("validaciones", validaciones);
//             List<Cliente> listaCliente = clienteDAO.selectAll();
//        request.setAttribute("lista", listaCliente);
//        request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        //  request.getRequestDispatcher("cliente.jsp").forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("correo");
        System.out.println("listar Correo " + correo);
        ReservaImpl reservaDAO = new ReservaImpl();
        List<Reserva> listaReserva = reservaDAO.listarReserva(correo);


        request.setAttribute("listaReserva", listaReserva);
        request.getRequestDispatcher("lista_reserva_user.jsp").forward(request, response);

//        ClienteImpl clienteDAO = new ClienteImpl();
//
//        List<Cliente> listaCliente = clienteDAO.selectAll();
//        request.setAttribute("lista", listaCliente);
//        request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
    }
}
