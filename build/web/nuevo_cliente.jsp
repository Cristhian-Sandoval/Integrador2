<!DOCTYPE html>
<%

    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("userName");
    String tipoUsuario = (String) objsession.getAttribute("tipoUsuario");
    if (tipoUsuario.equals("user") || usuario.equals("")) {
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
                    <a href="index.jsp" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>


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

                            </ul>
                        </li>
                        <li>
                            <a href="table.html"><i class="fa fa-flash "></i>Entrenadores </a>
                            <ul class="nav nav-second-level">

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-caret-square-o-right "></i>Planes <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">



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
                            <h1 class="page-head-line">Registro de cliente</h1>
                            <!--<h1 class="page-subhead-line">This is dummy text , you can replace it with your original text. </h1>-->

                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <div class="row" >
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    Datos Cliente
                                </div>
                                
                                <div class="panel-body" >
                                    <form action="clientecontroller.do" method="post">
                                        <input type="hidden" name="txtProceso" value="registro">
                                        <div class="form-group">
                                            <label>Nombres</label>
                                            <input class="form-control" type="text" id="txtNombre" name="txtNombre">
                                                

                                        </div>
                                        <div class="form-group">
                                            <label>Apellido Paterno</label>
                                            <input class="form-control" type="text" id="txtApellidoPat" name="txtApellidoPat">
                                               
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido Materno</label>
                                            <input class="form-control" type="text" id="txtApellidoMat" name="txtApellidoMat"> 
                                              
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input class="form-control" type="text" id="txtCorreo" name="txtCorreo">
                                               
                                        </div>
                                        <div class="form-group">
                                            <label>DNI</label>
                                            <input class="form-control" type="text" id="txtDNI" name="txtDNI">
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>Tel&eacutefono</label>
                                            <input class="form-control" type="text" id="txtTel" name="txtTel">
                                            
                                        </div>
                                        
                                        <button type="submit" class="btn btn-info">Registrar </button>

                                    </form>
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


    </body>
</html>
