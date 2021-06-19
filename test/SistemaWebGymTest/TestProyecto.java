/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaWebGymTest;

import com.gym.bean.Cliente;
import com.gym.bean.Sala;
import com.gym.bean.Usuario;
import com.gym.repo.impl.ClienteImpl;
import com.gym.repo.impl.SalaImpl;
import com.gym.repo.impl.UsuarioImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TestProyecto {
    
    public TestProyecto() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testValidaLogin(){

        Usuario result = new Usuario();
        String correo = "crisfer1990@hotmail.com" ;
        String clave = "81dc9bdb52d04dc20036dbd8313ed055";
        String expResult = "admin";
        UsuarioImpl instance = new UsuarioImpl();
        result = instance.login(correo, clave);
        assertEquals(expResult,result.getTipouser());
    }
    
    @Test
    public void testValidaEmailCliente(){

        String expResult = "dayala@utp.edu.pe" ;
        UsuarioImpl instance = new UsuarioImpl();
        String result = instance.validaemailcliente("dayala@utp.edu.pe");
        assertEquals(expResult,result);
    }
    
    @Test
    public void testFindSalaById(){
        Sala result = new Sala();
        String expResult = "Maquinas";
        SalaImpl instance = new SalaImpl();
        result = instance.selectById(1);
        assertEquals(expResult, result.getDescripcion());
    }
    
    //@Test
    public void testRegisterSala(){
        Sala sala = new Sala();
        sala.setDescripcion("Sala de Test");
        sala.setAforo(10);
        boolean expResult = true;
        SalaImpl instance = new SalaImpl();
        boolean result = instance.insert(sala);
        
        assertEquals(expResult,result);
    }
            
    
    //@Test
    public void testRegisterCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombres("Test");
        cliente.setApepat("ApePatTest");
        cliente.setApemat("ApeMatTest");
        cliente.setCorreo("test@gmail.com");
        cliente.setNumdoc("40302010");
        cliente.setTelefono("987654321");
        boolean expResult = true;
        ClienteImpl instance = new ClienteImpl();
        boolean result = instance.insert(cliente);
        
        assertEquals(expResult,result);
    }
    
    @Test
    public void testUpdateCliente(){
         Cliente cliente = new Cliente();
        cliente.setNombres("TestUpdate");
        cliente.setApepat("ApePatTest");
        cliente.setApemat("ApeMatTest");
        cliente.setCorreo("test@gmail.com");
        cliente.setNumdoc("40302010");
        cliente.setTelefono("987654321");
        cliente.setEstado(true);
        cliente.setId(25);
        boolean expResult = true;
        ClienteImpl instance = new ClienteImpl();
        boolean result = instance.update(cliente);
        
        assertEquals(expResult,result);
    }
}
