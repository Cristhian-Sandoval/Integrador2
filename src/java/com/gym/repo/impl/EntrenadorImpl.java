/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo.impl;

import com.gym.bean.Cliente;
import com.gym.bean.Entrenador;
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
public class EntrenadorImpl implements IGenericRepo<Entrenador> {
    private static ConnectionDB conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;
    private static CallableStatement cstm = null;
    
    // LOS QUERYS 
    private static final String SQL_SELECT_ALL = "select idInst,Nombre,ApellidoPat,ApellidoMat,Celular,Correo,Dni,Estado from instructor";
    private static final String SQL_INSERT = "insert into instructor(Nombre,ApellidoPat,ApellidoMat,Celular,Correo,Dni) values(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from instructor where idInst=?";
    private static final String SQL_SELECT_ID = "select * from instructor where idInst=?";
    private static final String SQL_UPDATE = "update instructor set Nombre=?, ApellidoPat=?,ApellidoMat=?, Celular=?,Correo=?, Dni=?, Estado=? where idInst=?";

    public EntrenadorImpl() {
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
    public Boolean insert(Entrenador t) {
         Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellidopat());
            pstm.setString(3, t.getApellidomat());
            pstm.setString(4, t.getCelular());
            pstm.setString(5, t.getCorreo());
            pstm.setString(6, t.getDni());          
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
    public Boolean update(Entrenador t) {
        Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellidopat());
            pstm.setString(3, t.getApellidomat());
            pstm.setString(4, t.getCelular());
            pstm.setString(5, t.getCorreo());
            pstm.setString(6, t.getDni());
            pstm.setBoolean(7, t.isEstado());  
            pstm.setInt(8, t.getId());
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
    public Boolean recupera(Entrenador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Entrenador t) {
         Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_DELETE);           
            pstm.setInt(1, t.getId()); 
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
    public List<Entrenador> selectAll() {
        List<Entrenador> list = new ArrayList<Entrenador>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ALL);
            res = pstm.executeQuery();
            
            while (res.next()) {
                Entrenador c = new Entrenador(); 
                c.setId(res.getInt(1));
                c.setNombre(res.getString(2));
                c.setApellidopat(res.getString(3));
                c.setApellidomat(res.getString(4));
                c.setCelular(res.getString(5));
                c.setCorreo(res.getString(6));
                c.setDni(res.getString(7));
                c.setEstado(res.getBoolean(8));
                                          
                list.add(c);                
            }            
        } catch (Exception e) {
            System.out.println("Error al consultar" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Entrenador selectById(int id) {
         Entrenador c = new Entrenador();
        try {           
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            while (res.next()) {                     
                c.setId(res.getInt(1)); 
                c.setNombre(res.getString(2));
                c.setApellidopat(res.getString(3));
                c.setApellidomat(res.getString(4));
                c.setCelular(res.getString(5));
                c.setCorreo(res.getString(6));
                c.setDni(res.getString(7));
                c.setEstado(res.getBoolean(8));
    
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
    public List<Entrenador> selectByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
