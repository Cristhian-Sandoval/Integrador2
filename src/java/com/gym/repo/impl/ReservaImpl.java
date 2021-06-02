/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo.impl;

import com.gym.bean.Cliente;
import com.gym.bean.Hora;
import com.gym.bean.Reserva;
import com.gym.bean.Sala;
import com.gym.conecction.ConnectionDB;
import com.gym.repo.IGenericRepo;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ReservaImpl implements IGenericRepo<Reserva> {

    private static ConnectionDB conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;
    private static CallableStatement cstm = null;

    // LOS QUERYS 
    private static final String SQL_HORAS = "select idHora,Hora from horas where estado=1";
    private static final String SQL_SALAS = "select idSala ,Descripcion,Aforo from sala where Estado=1";
    private static final String SQL_IDCLIENTE = "select idCliente from cliente where correo=?";
    private static final String SQL_INSERT = "insert into reserva(idSala,idCliente,Fecha,Hora) values(?,?,?,?)";
    private static final String SQL_VALIDAAFORO = "select a.*\n"
            + "from \n"
            + "(select count(r.idreserva) reserva,\n"
            + "	   s.Aforo\n"
            + "from reserva r, \n"
            + "	 sala s,\n"
            + "	 horas h\n"
            + "where r.idsala=s.idsala\n"
            + "and r.Hora=h.idhora\n"
            + "and r.Fecha=?\n"
            + "and h.idHora=?\n"
            + "group by Aforo) a\n"
            + "where reserva=aforo;";

    private static final String SQL_LISTARESERVAALL = "select r.idReserva,\n"
            + "       c.Nombres,\n"
            + "	   c.ApellidoMaterno,\n"
            + "	   c.ApellidoMaterno Apellidos,\n"
            + "	   r.Fecha Fecha_Reserva,\n"
            + "	   h.Hora Hora_Reserva,\n"
            + "	   s.Descripcion Sala,\n"
            + "	   r.Estado\n"
            + "from reserva r,\n"
            + "	 horas h,\n"
            + "	 sala s,\n"
            + "	 cliente c\n"
            + "where c.idCliente=r.idCliente\n"
            + "and r.Hora=h.idHora\n"
            + "and r.idSala=s.idSala\n"
            + "order by r.Fecha,h.hora";
    private static final String SQL_VALIDARESERVA = "select * from reserva r where r.idCliente=? and r.Fecha=?";
    private static final String SQL_LISTARESERVA = "select r.idReserva,\n"
            + "	   r.Fecha,\n"
            + "	   h.Hora,\n"
            + "	   s.Descripcion Sala,\n"
            + "	   s.Aforo\n"
            + "from reserva r,\n"
            + "	 horas h,\n"
            + "	 sala s,\n"
            + "	 cliente c\n"
            + "where c.idCliente=r.idCliente\n"
            + "and c.Correo=?\n"
            + "and r.Hora=h.idHora\n"
            + "and r.idSala=s.idSala\n"
            + "order by r.Fecha,h.hora";

    public ReservaImpl() {
        conn = ConnectionDB.newInstance();
    }

    private void closeConnection() {
        try {
            if (res != null) {
                res.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.closeConnection();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar conexion");
            e.printStackTrace();
        }
    }

    @Override
    public Boolean insert(Reserva t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int insertReserva(Reserva t) {
        int result = 0;

        try {
            //VALIDAMOS QUE EL USUARIO NO TENGA UNA RESERVA EL MISMO DÍA
            pstm = conn.getConnection().prepareStatement(SQL_VALIDARESERVA);
            pstm.setInt(1, t.getIdcliente().getId());
            pstm.setString(2, t.getFecha());
            res = pstm.executeQuery();
            while (res.next()) {
                result = res.getInt(1);
            }

            if (result > 0) {
                closeConnection();
                result = 1;
                System.out.println("TIENE RESERVA MISMO DIA");
                return result;

            } else if (result == 0) {
                //VALIDAMOS EL AFORO
                pstm = conn.getConnection().prepareStatement(SQL_VALIDAAFORO);
                pstm.setString(1, t.getFecha());
                pstm.setInt(2, t.getHora().getIdHora());
                res = pstm.executeQuery();
                while (res.next()) {
                    result = res.getInt(1);
                }

                if (result > 0) {
                    System.out.println("NO HAY AFORO");
                    closeConnection();
                    result = 2;
                    return result;

                }
            }

            pstm = conn.getConnection().prepareStatement(SQL_INSERT);
            pstm.setInt(1, t.getIdsala().getIdSala());
            pstm.setInt(2, t.getIdcliente().getId());
            pstm.setString(3, t.getFecha());
            pstm.setInt(4, t.getHora().getIdHora());
            if (pstm.executeUpdate() > 0) {
                result = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Boolean update(Reserva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean recupera(Reserva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Reserva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> selectAll() {
        List<Reserva> list = new ArrayList<Reserva>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_LISTARESERVAALL);
            res = pstm.executeQuery();

            while (res.next()) {
                Cliente c = new Cliente();
                c.setNombres(res.getString(2));
                c.setApepat(res.getString(3));
                c.setApemat(res.getString(4));
                

                Reserva r = new Reserva();
                r.setIdReserva(res.getInt(1));
                r.setFecha(res.getString(5));
                r.setEstado(res.getBoolean(8));
                r.setIdcliente(c);
                Hora h = new Hora();
                h.setHora(res.getString(6));
                r.setHora(h);

                Sala s = new Sala();
                s.setDescripcion(res.getString(7));
                r.setIdsala(s);

                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Reserva selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> selectByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Hora> listarHoras() {
        List<Hora> list = new ArrayList<Hora>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_HORAS);
            res = pstm.executeQuery();

            while (res.next()) {
                Hora h = new Hora();
                h.setIdHora(res.getInt(1));
                h.setHora(res.getString(2));
                //h.setEstado(res.getBoolean(3));

                list.add(h);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Sala> listarSalas() {
        List<Sala> list = new ArrayList<Sala>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_SALAS);
            res = pstm.executeQuery();

            while (res.next()) {
                Sala s = new Sala();
                s.setIdSala(res.getInt(1));
                s.setDescripcion(res.getString(2));
                s.setAforo(res.getInt(3));

                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public Cliente mostrarIdCliente(String correo) {

        Cliente cliente = null;

        try {
            pstm = conn.getConnection().prepareStatement(SQL_IDCLIENTE);
            pstm.setString(1, correo);
            res = pstm.executeQuery();

            while (res.next()) {
                cliente = new Cliente();
                cliente.setId(res.getInt(1));
            }

        } catch (Exception e) {
            System.err.println("ERROR validaemailcliente : " + e);
        } finally {
            closeConnection();
        }

        return cliente;

    }

    public List<Reserva> listarReserva(String correo) {
        List<Reserva> list = new ArrayList<Reserva>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_LISTARESERVA);
            System.out.println("llega el correo " + correo);
            pstm.setString(1, correo);
            res = pstm.executeQuery();

            while (res.next()) {
                Reserva r = new Reserva();
                r.setIdReserva(res.getInt(1));
                r.setFecha(res.getString(2));

                Hora h = new Hora();
                h.setHora(res.getString(3));
                r.setHora(h);

                Sala s = new Sala();
                s.setDescripcion(res.getString(4));
                s.setAforo(res.getInt(5));
                r.setIdsala(s);

                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

}
