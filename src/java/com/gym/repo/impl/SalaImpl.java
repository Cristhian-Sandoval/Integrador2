/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo.impl;

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
public class SalaImpl implements IGenericRepo<Sala> {

    private static ConnectionDB conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;
    private static CallableStatement cstm = null;

    // LOS QUERYS 
    private static final String SQL_SELECT_ALL = "select idSala,Descripcion,Aforo,Estado from sala";
    private static final String SQL_SELECT_ID = "select * from sala where idSala=?";
    private static final String SQL_DELETE = "delete from sala where idSala=?";
    private static final String SQL_UPDATE = "update sala set Descripcion=?, Aforo=?,Estado=? where idSala=?";
    private static final String SQL_INSERT = "insert into sala(Descripcion,Aforo) values(?,?)";

    public SalaImpl() {
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
    public Boolean insert(Sala t) {
         Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getDescripcion());
            pstm.setInt(2, t.getAforo());
         
            if (pstm.executeUpdate() > 0) {
                result = true;
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
    public Boolean update(Sala t) {
        Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, t.getDescripcion());
            pstm.setInt(2, t.getAforo());
            pstm.setBoolean(3, t.isEstado());
            pstm.setInt(4, t.getIdSala());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actulizar" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Boolean recupera(Sala t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public Boolean delete(Sala t) {
        Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_DELETE);
            pstm.setInt(1, t.getIdSala());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public List<Sala> selectAll() {
        List<Sala> list = new ArrayList<Sala>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ALL);
            res = pstm.executeQuery();

            while (res.next()) {
                Sala c = new Sala();
                c.setIdSala(res.getInt(1));
                c.setDescripcion(res.getString(2));
                c.setAforo(res.getInt(3));
                c.setEstado(res.getBoolean(4));

                list.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Sala selectById(int id) {
        Sala c = new Sala();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            while (res.next()) {
                c.setIdSala(res.getInt(1));
                c.setDescripcion(res.getString(2));
                c.setAforo(res.getInt(3));
                c.setEstado(res.getBoolean(4));

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return c;
    }

    @Override
    public List<Sala> selectByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
