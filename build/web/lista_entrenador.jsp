<!DOCTYPE html>
<%

    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("userName");
    String tipoUsuario = (String) objsession.getAttribute("tipoUsuario");

    if (usuario == null || tipoUsuario == null) {
        response.sendRedirect("error.jsp");
        return;
    }

    if (tipoUsuario.equals("user") || usuario.equals("")) {
        response.sendRedirect("error.jsp");
    }

%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Responsive Bootstrap Advance Admin Template</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!--CUSTOM BASIC STYLES-->
        <link href="assets/css/basic.css" rel="stylesheet" />
        <!--CUSTOM MAIN STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Sistema de gimnasios</a>
                </div>

                <div class="header-right">

                    <!--<a href="message-task.html" class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>-->
                    <!--<a href="message-task.html" class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>-->
                    <a href="cerrar.do" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>


                </div>
            </nav>
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li>
                            <div class="user-img-div">
                                <img src="assets/img/user.png" class="img-thumbnail" />

                                <div class="inner-text">
                                    <!-- Jhon Deo Alex-->
                                    <br />
                                    <!-- <small>Last Login : 2 Weeks Ago </small>-->
                                </div>
                            </div>

                        </li>


                        <li>
                            <a class="active-menu" href="admin.jsp"><i class="fa fa-dashboard "></i>Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users "></i>Clientes <span class="fa arrow"></span></a>   
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="nuevo_cliente.jsp"><i class="fa fa-user"></i>Nuevo Cliente</a>
                                </li>
                                <li>
                                    <a href="clientecontroller.do?txtProceso=mostrar"><i class="fa fa-users "></i>Listar Clientes</a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-desktop "></i>Usuarios <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-yelp "></i>Reservas <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="reservacontroller.do?txtProceso=mostrara"><i class="fa fa-users "></i>Listar Reservas</a>
                                </li>   
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-flash "></i>Entrenadores </a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="nuevo_entrenador.jsp"><i class="fa fa-user"></i>Nuevo Entrenador</a>
                                </li>
                                <li>
                                    <a href="entrenadorcontroller.do?txtProceso=mostrar"><i class="fa fa-users "></i>Listar Entrenadores</a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-caret-square-o-right "></i>Salas <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="nueva_sala.jsp"><i class="fa fa-area-chart"></i>Nueva Sala</a>
                                </li>
                                <li>
                                    <a href="salacontroller.do?txtProceso=mostrar"><i class="fa fa-list"></i>Listar Salas</a>
                                </li>

                            </ul>
                        </li>

                    </ul>

                </div>

            </nav>
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-head-line">Lista de entrenadores</h1>
                            <!--<h1 class="page-subhead-line">This is dummy text , you can replace it with your original text. </h1>-->

                        </div>
                    </div>

                    <!-- /. ROW  -->
                    <div class="row">
                        <div class="col-md-12">
                            <!--    Hover Rows  -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Entrenadores 
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Nombres</th>   <!-- Celda de cabecera de la columna 1 -->
                                                    <th>Apellido Paterno</th>   <!-- Celda de cabecera de la columna 2 -->
                                                    <th>Apellido Materno</th>
                                                    <th>Tel&eacutefono</th>   <!-- Celda de cabecera de la columna 3 -->
                                                    <th>Correo</th>
                                                    <th>Dni</th>
                                                    <th>Estado</th>                            
                                                    <th>Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${lista}" var="entrenador" >
                                                    <tr>
                                                        <!--<td>${entrenador.getId()}</td>-->
                                                        <td>${entrenador.getNombre()}</td>
                                                        <td>${entrenador.getApellidopat()}</td>  
                                                        <td>${entrenador.getApellidomat()}</td>
                                                        <td>${entrenador.getCelular()}</td>
                                                        <td>${entrenador.getCorreo()}</td>
                                                        <td>${entrenador.getDni()}</td>

                                    <!--<td><td>${entrenador.isEstado()}</td>-->
                                                        <td>
                                                            <c:choose>  
                                                                <c:when test="${entrenador.isEstado()}">
                                                                    Activo
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Desactivo
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td>            
                                                            <input type="hidden" name="id" id="id_cli" value="${entrenador.getId()}">
                                                                <a href="#editClienteModal" class="edit" title="Editar" data-toggle="modal"><i class="fa fa-edit"></i></a>                     
                                                                <a href="#" data-href="entrenadorcontroller.do?txtProceso=borrar&id=<c:out value='${entrenador.id}'/>" data-target="#deleteEmployeeModal" class="delete" title="Borrar" data-toggle="modal"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- End  Hover Rows  -->
                        </div>

                    </div>
                    <!-- /. ROW  -->

                </div>
                <!-- /. PAGE INNER  -->
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <!--MODAL ELIMINAR ENTRENADOR-->
        <div id="deleteEmployeeModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">                                                  
                    <div class="modal-header">						
                        <h4 class="modal-title">Eliminar Entrenador</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p>Estas seguro que quieres eliminar este entrenador?</p>
                        <p class="text-warning"><small>Esta acci&oacute;n no se puede regresar.</small></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <a class="btn btn-danger btn-ok">Eliminar</a>
                    </div>
                </div>
            </div>
        </div>



        <!--MODAL EDITAR ENTRENADOR -->

        <div id="editClienteModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="entrenadorcontroller.do" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Editar Entrenador</h4>
                            <input type="hidden" name="id" id="id_cli">
                                <input type="hidden" name="txtProceso" value="editar">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body">					
                                        <div class="form-group">
                                            <label>Nombres</label>
                                            <input id="nombre" name="nombre" type="text" class="form-control" pattern="[A-Za-z ]+" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido Paterno</label>
                                            <input id="apepat" name="apepat" type="text" class="form-control" pattern="[A-Za-z]+" required>
                                        </div>  
                                        <div class="form-group">
                                            <label>Apellido Materno</label>
                                            <input id="apepat" name="apemat" type="text" class="form-control" pattern="[A-Za-z]+" required>
                                        </div> 
                                        <div class="form-group">
                                            <label>Tel&eacute;fono</label>
                                            <input id="fono" name="fono" type="text" class="form-control"  pattern="[0-9]{9}"required>
                                        </div>
                                        <div class="form-group">
                                            <label id="dni2">Correo</label>
                                            <input id="email" name="email" type="email" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>DNI</label>
                                            <input id="dni" name="dni" type="text" class="form-control" pattern="[0-9]{8}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Activo</label>
                                            <input type = "checkbox" name="activo" id="activo"
                                                   class = "mdl-checkbox__input">
                                        </div>


                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <input type="submit" class="btn btn-info" name="accion" value="Guardar">

                                                </div>
                                                </form>
                                                </div>
                                                </div>
                                                </div>


                                                <div id="footer-sec">
                                                    &copy; 2021 UTP | Design By : <a href="#/" target="_blank">Alumnos Integrador II</a>
                                                </div>
                                                <!-- /. FOOTER  -->
                                                <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
                                                <!-- JQUERY SCRIPTS -->
                                                <script src="assets/js/jquery-1.10.2.js"></script>
                                                <!-- BOOTSTRAP SCRIPTS -->
                                                <script src="assets/js/bootstrap.js"></script>
                                                <!-- METISMENU SCRIPTS -->
                                                <script src="assets/js/jquery.metisMenu.js"></script>
                                                <!-- CUSTOM SCRIPTS -->
                                                <script src="assets/js/custom.js"></script>



                                                <script type="text/javascript">
                                                    $(document).ready(function () {

                                                        $('#deleteEmployeeModal').on('show.bs.modal', function (e) {
                                                            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
                                                        });

                                                        $('table .edit').on('click', function () {
                                                            var id = $(this).parent().find('#id_cli').val();
                                                            console.log("entramos a actualizar" + id);

                                                            $.ajax({
                                                                type: 'GET',
                                                                url: "entrenadorcontroller.do?txtProceso=mostrarID",
                                                                data: {id: id},
                                                                success: function (result) {

                                                                    console.log(result);
                                                                    console.log(result.correo);

                                                                    $('#editClienteModal #id_cli').val(id);
                                                                    $('#editClienteModal #nombre').val(result.nombre);
                                                                    $('#editClienteModal #apepat').val(result.apellidopat);
                                                                    $('#editClienteModal #apemat').val(result.apellidomat);
                                                                    $('#editClienteModal #email').val(result.correo);
                                                                    $('#editClienteModal #dni').val(result.dni);
                                                                    $('#editClienteModal #fono').val(result.celular);
                                                                    $('#editClienteModal #activo').val(result.estado);
                                                                    var activo = result.estado;

                                                                    $('#activo').prop("checked", activo);

                                                                }

                                                            });
                                                        });

                                                    });

                                                </script>
                                                </body>
                                                </html>
