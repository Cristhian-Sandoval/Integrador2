<!DOCTYPE html>
<%

    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("userName");
    String tipoUsuario = (String) objsession.getAttribute("tipoUsuario");

    if (usuario == null || tipoUsuario == null) {
        response.sendRedirect("error.jsp");
        return;
    }

    if (tipoUsuario.equals("admin") || usuario.equals("")) {
        response.sendRedirect("error.jsp");
    }

%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Responsive Bootstrap Advance Admin Template</title>

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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.min.css" >
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" type="text/css" />
            <link rel="stylesheet" href="resources/css/styles_formulario.css">
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                                <!--<a href="#" class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>-->
                                <!--<a href="#" class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>-->
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
                                        <a class="active-menu" href="admin_user.jsp"><i class="fa fa-dashboard "></i>Dashboard</a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-desktop "></i>Reserva<span class="fa arrow"></span></a>   
                                        <ul class="nav nav-second-level">
                                            <li>
                                                <input type="hidden" name="txtCliente" id="txtCliente" value="${userName}">
                                                    <a href="reservacontroller.do?txtProceso=mostrar&correo=<c:out value='${userName}'/>"><i class="fa fa-toggle-on"></i>Nueva Reserva</a>
                                            </li>
                                            <li>
                                                <a href="reservacontroller.do?txtProceso=listar&correo=<c:out value='${userName}'/>"><i class="fa fa-bell "></i>Listar Reservas</a>
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
                                        <h1 class="page-head-line">Registro de reserva</h1>
                                        <!--<h1 class="page-subhead-line">This is dummy text , you can replace it with your original text. </h1>-->

                                    </div>
                                </div>
                                <!-- /. ROW  -->
                                <div class="row" >
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="panel panel-info">
                                            <div class="panel-heading">
                                                Nueva reserva
                                            </div>

                                            <div class="panel-body" >
                                                <form action="reservacontroller.do" method="post">
                                                    <input type="hidden" name="txtProceso" value="registro">
                                                        <input type="hidden" name="txtidCliente" id="txtidCliente" value="${idCliente}">
                                                            <input type="hidden" name="correo" id="correo" value="${userName}">
                                                                <div class="form-group">
                                                                    <label>Sala</label>
                                                                    <select class="form-control" name="txtSala" id="txtSala" required>
                                                                        <option value="" selected disabled="disabled">Seleccione la Sala</option>
                                                                        <c:forEach items="${listaSalas}" var="listaSalas" >
                                                                            <option value=<c:out value='${listaSalas.getIdSala() }'/>> ${listaSalas.getDescripcion()}</option>                                                                     
                                                                        </c:forEach>
                                                                    </select>

                                                                </div>
                                                                <div class="form-group">
                                                                    <label>Fecha</label>
                                                                    <!--<div id="date-picker-example" class="md-form md-outline input-with-post-icon datepicker">
                                                                        <input placeholder="Select date" type="text" id="example" class="form-control">
                                                                            <label for="example">Try me...</label>
                                                                            <i class="fa fa-calendar input-prefix" tabindex=0></i>
                                                                    </div>-->


                                                                    <!--<div class="input-group date" data-provide="datepicker">
                                                                        <input type="text" class="form-control" required="" name="txtFecha" id="txtFecha">
                                                                            <div class="input-group-addon">
                                                                                <span class="glyphicon glyphicon-calendar"></span>
                                                                            </div>
                                                                    </div>-->
                                                                    <div class="input-group">
                                                                        <input type="text" name="txtFecha" id="txtFecha" class="datepicker"  required />
                                                                    </div>


                                                                </div>

                                                                <div class="form-group">   
                                                                    <label>Hora</label>
                                                                    <select class="form-control" name="txtHora" id="txtHora" required>
                                                                        <option value="" selected disabled="disabled">Seleccione la Hora</option>
                                                                        <c:forEach items="${listaHora}" var="listaHora" >
                                                                            <option value=<c:out value='${listaHora.getIdHora() }'/>> ${listaHora.getHora()}</option>                                                                     
                                                                        </c:forEach>

                                                                    </select>
                                                                </div>




                                                                <button type="submit" class="btn btn-info">Registrar </button>

                                                                </form>
                                                                <br>
                                                                    <% if (request.getAttribute("validaciones") != "" && request.getAttribute("validaciones") != null) {

                                                                    %>

                                                                    <div id="flotante" class="alert alert-danger" >${requestScope.validaciones}</div>

                                                                    <%                                                                        }

                                                                    %>

                                                                    </div>
                                                                    </div>
                                                                    </div>

                                                                    </div>


                                                                    </div>
                                                                    <!-- /. PAGE INNER  -->
                                                                    </div>
                                                                    <!-- /. PAGE WRAPPER  -->
                                                                    </div>
                                                                    <!-- /. WRAPPER  -->
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
                                                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
                                                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/locales/bootstrap-datepicker.en-GB.min.js" charset="UTF-8"></script>

                                                                    <script type="text/javascript">

                                                                        $(document).ready(function () {

                                                                            $('#txtFecha').datepicker(
                                                                                    {
                                                              
                                                                                        startDate: '+0d',
                                                                                        format: 'dd/mm/yyyy',
                                                                                        datesDisabled: [
                                                                                            "14/06/2021", // 20 de enero de 2019
                                                                                            "13/06/2021", // 20 de febrero de 2019
                                                                                        ],
                                                                                        setMinDate : new Date
                                                                                    }

                                                                            );


                                                                        });


                                                                        function mostrar() {
                                                                            div = document.getElementById('flotante');
                                                                            div.style.display = '';
                                                                        }


                                                                    </script>
                                                                    </body>
                                                                    </html>
