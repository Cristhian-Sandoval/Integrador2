/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo.impl;

import com.gym.bean.Cliente;
import com.gym.bean.Usuario;
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
public class ClienteImpl implements IGenericRepo<Cliente>{
    
    private static ConnectionDB conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;
    private static CallableStatement cstm = null;

    // LOS QUERYS 
    private static final String SQL_SELECT_ALL = "select idCLiente,Nombres,ApellidoPaterno,ApellidoMaterno,Correo,NumDoc,Telefono,Estado from cliente";
    private static final String SQL_INSERT = "insert into cliente(Nombres,ApellidoPaterno,ApellidoMaterno,Correo,NumDoc,Telefono) values(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from cliente where idCliente=?";
    private static final String SQL_SELECT_ID = "select * from cliente where idCliente=?";
    private static final String SQL_UPDATE = "update cliente set nombres=?, ApellidoPaterno=?, ApellidoMaterno=?,Correo=?, NumDoc=?, Telefono=?, Estado=? where idCLiente=?";
        
     public ClienteImpl() {
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
    public Boolean insert(Cliente t) {
        Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, t.getNombres());
            pstm.setString(2, t.getApepat());
            pstm.setString(3, t.getApemat());
            pstm.setString(4, t.getCorreo());
            pstm.setString(5, t.getNumdoc());
            pstm.setString(6, t.getTelefono());            
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
    public Boolean update(Cliente t) {
        Boolean result = false;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, t.getNombres());
            pstm.setString(2, t.getApepat());
            pstm.setString(3, t.getApemat());
            pstm.setString(4, t.getCorreo());
            pstm.setString(5, t.getNumdoc());
            pstm.setString(6, t.getTelefono());  
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
    public Boolean recupera(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Cliente t) {
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
    public List<Cliente> selectAll() {
        List<Cliente> list = new ArrayList<Cliente>();
        try {
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ALL);
            res = pstm.executeQuery();
            
            while (res.next()) {
                Cliente c = new Cliente();   
                c.setId(res.getInt(1));
                c.setNombres(res.getString(2));
                c.setApepat(res.getString(3));
                c.setApemat(res.getString(4));
                c.setCorreo(res.getString(5));
                c.setNumdoc(res.getString(6));
                c.setTelefono(res.getString(7));
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
    public Cliente selectById(int id) {
        Cliente c = new Cliente();
        try {           
            pstm = conn.getConnection().prepareStatement(SQL_SELECT_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            while (res.next()) {                     
                c.setId(res.getInt(1)); 
                c.setNombres(res.getString(2));
                c.setApepat(res.getString(3));
                c.setApemat(res.getString(4));
                c.setCorreo(res.getString(5));
                c.setNumdoc(res.getString(6));
                c.setTelefono(res.getString(7));
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
    public List<Cliente> selectByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
