<%-- 
    Document   : cliente
    Created on : 28/04/2021, 11:29:56 PM
    Author     : Usuario
--%>
<%

    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("userName");
    String tipoUsuario = (String) objsession.getAttribute("tipoUsuario");
    if (tipoUsuario.equals("user") || usuario.equals("")) {
        response.sendRedirect("error.jsp");
    }

%>


<html>
    <head>  
        <title>Cliente</title>
        <%@include file="WEB-INF/jspf/cmeta.jspf" %>
        <%@include file="WEB-INF/jspf/cstyles.jspf" %>       
        <%@include file="WEB-INF/jspf/cheader.jspf" %>
        <%@include file="WEB-INF/jspf/cnav.jspf" %>

        <link rel="stylesheet" href="assets/css/styles_formulario.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">        
    </head>
    <body>  
        <section>
            <div id="wrapper">
                <% String x = (String) session.getAttribute("accion");
                        if (x.equals("1")) { %>
                <form action="clientecontroller.do" method="post"> 
                    <div class="">
                        <input type="hidden" name="txtProceso" value="registro">
                    </div> 
                    <fieldset>
                        <legend>Registro Cliente</legend><br>
                        <div>
                            <label for="casilla">Nombres &nbsp;</label>
                            <input type="text" name="txtNombre" placeholder="First Name" id="txtNombre"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                        <div>
                            <label for="casilla">Apellido Paterno &nbsp;</label>
                            <input type="text" name="txtApellidoPat" placeholder="Last Name" id="txtApellidoPat"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                        <div>
                            <label for="casilla">Apellido Materno &nbsp;</label>
                            <input type="text" name="txtApellidoMat" placeholder="Last Name" id="txtApellidoMat"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                        <div>
                            <label for="casilla">Correo &nbsp;</label>
                            <input type="text" name="txtCorreo" placeholder="Email" id="txtCorreo"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                        <div>
                            <label for="casilla">DNI &nbsp;</label>
                            <input type="text" name="txtDNI" placeholder="DNI" id="txtDNI"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                        <div>
                            <label for="casilla">Telefono &nbsp;</label>
                            <input type="text" name="txtTel" placeholder="Telefono" id="txtTel"
                                   oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                        </div>
                                                  
                        <label for="casilla">&nbsp;</label>                           
                        <button type="submit" class="btn btn-primary"><i class="material-icons">&#xe146;</i> <span>Grabar</span></button>
                        <a href="clientecontroller.do?txtProceso=mostrar" class="btn btn-primary"><i class="material-icons">&#xe879;</i> <span>Salir</span></a>  
                        <br><br>
                        <div class="vali">${requestScope.validaciones}</div>
                    </fieldset>    
                </form>
                <% } else if (x.equals("2")) {%>
                <form action="usuariocontroller.do" method="post">
                    <div class="">
                        <input type="hidden" name="txtProceso" value="editar">
                    </div> 
                    <fieldset>
                        <legend>Actualizar Usuario</legend><br>
                        <div>
                            <label for="casilla">ID &nbsp;</label>
                            <input type="number" name="txtID" id="txtID" value='${usuario.getId()}' readonly="readonly" />     
                        </div>
                        <div>
                            <label for="casilla">Nombre &nbsp;</label>
                            <input type="text" name="txtNombre" id="txtNombre" value='${usuario.getNombre()}' required/>
                        </div>
                        <div>
                            <label for="casilla">Apellidos &nbsp;</label>
                            <input type="text" name="txtApellido" id="txtApellido" value='${usuario.getApellidos()}' required/>
                        </div>
                        <div>
                            <label for="casilla">Correo &nbsp;</label>
                            <input type="text" name="txtCorreo" id="txtCorreo" value='${usuario.getCorreo()}' required/>
                        </div>
                        <div>
                            <label for="casilla">Contraseña &nbsp;</label>
                            <input type="password" name="txtClave" id="txtClave" value='${usuario.getClave()}' required/>
                        </div>
                        <div>
                              <label for="casilla">Rol Usuario &nbsp;</label>  
                            <form action="#" method="post">   
                                <input type="hidden" name="rol" id="rol" value='${usuario.getRol()}'> 
                                <select class="transporte" name="txtRol" id="txtRol">                                       
                                    <option value='ADMINISTRADOR'>Administrador</option>
                                    <option value='BASICO'>Básico</option>
                                </select>
                                <div>
                                    <label for="casilla">Estado &nbsp;</label>
                                    <input type="hidden" name="est" id="est" value='${usuario.getEstado()}'> 
                                    <select class="transporte" name="txtEstado" id="txtEstado">
                                        <option value="0">Activo</option>
                                        <option value="1">Inactivo</option>
                                    </select>
                                </div>
                            </form>                                   
                        </div>
                        <label for="casilla">&nbsp;</label>    
                        <button type="submit" class="btn btn-primary"><i class="material-icons">&#xe150;</i> <span>Modificar</span></button>
                        <a href="usuariocontroller.do?txtProceso=mostrar" class="btn btn-primary"><i class="material-icons">&#xe879;</i> <span>Salir</span></a>                         
                        <br><br>
                        <div class="vali">${requestScope.validaciones}</div>                            
                    </fieldset>    
                </form>    
                <%}%>
            </div>	
        </section>
        <%@include file="WEB-INF/jspf/cfooter.jspf" %>
        <%@include file="WEB-INF/jspf/cjs.jspf" %>
    </body>
</html>