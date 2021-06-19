/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.repo.impl;

import com.gym.bean.Usuario;
import com.gym.conecction.ConnectionDB;
import com.gym.repo.IGenericRepo;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioImpl implements IGenericRepo<Usuario> {

    private static ConnectionDB conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet res = null;

    private static CallableStatement cstm = null;

    // LOS QUERYS 
    private static final String SQL_LOGIN = "select tipouser from usuario where correo=? and clave=? and estado=1";
    private static final String SQL_INSERT = "insert into usuario(correo,clave,tipouser) values(?,?,'user') ";
    private static final String SQL_VALIDAEMAILCLIENTE = "select correo from cliente where correo=?";
    private static final String SQL_VALIDAEMAIL = "select correo from usuario where correo=? ";

    public UsuarioImpl() {
        conn = ConnectionDB.newInstance();
    }

    public Usuario login(String correo, String clave) {
        Usuario user = null;
        try {
            pstm = conn.getConnection().prepareStatement(SQL_LOGIN);
            pstm.setString(1, correo);
            pstm.setString(2, clave);
            res = pstm.executeQuery();
            while (res.next()) {
                user = new Usuario();
                user.setTipouser(res.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error en el login");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    @Override
    public Boolean insert(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean recupera(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> selectByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String validaemail(String correo) {

        String datoExits = "!$#$%&";

        try {
            pstm = conn.getConnection().prepareStatement(SQL_VALIDAEMAIL);
            pstm.setString(1, correo);
            res = pstm.executeQuery();

            while (res.next()) {
                datoExits = res.getString(1);
            }

        } catch (Exception e) {
            System.err.println("ERROR: validaemail " + e);
        } finally {
            closeConnection();
        }

        return datoExits;

    }

    public String validaemailcliente(String correo) {

        String datoExits = "!$#$%&";

        try {
            pstm = conn.getConnection().prepareStatement(SQL_VALIDAEMAILCLIENTE);
            pstm.setString(1, correo);
            res = pstm.executeQuery();

            while (res.next()) {
                datoExits = res.getString(1);
            }

        } catch (Exception e) {
            System.err.println("ERROR validaemailcliente : " + e);
        } finally {
            closeConnection();
        }

        return datoExits;

    }

    public int insertUser(Usuario t) {
        int result = 0;
        try {
            if (!validaemail(t.getCorreo()).equals(t.getCorreo())) {
                //no existe correo registrado entonces validamos si existe el cliente
                if (validaemailcliente(t.getCorreo()).equals(t.getCorreo())) {
                    pstm = conn.getConnection().prepareStatement(SQL_INSERT);
                    pstm.setString(1, t.getCorreo());
                    pstm.setString(2, t.getClave());
                    if (pstm.executeUpdate() > 0) {
                        result = 1;
                    }

                } else {
                    result = 2; //no existe cliente 
                }

            } else {
                result = 3; //el correo ya existe registrado
            }

        } catch (Exception e) {
            System.out.println("Error al insertar" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;

    }

}
