<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!--PAGE LEVEL STYLES-->
        <link href="assets/css/pricing.css" rel="stylesheet" />

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
                            <a class="active-menu" href="admin_user.jsp"><i class="fa fa-dashboard "></i>Dashboard</a>
                        </li>
                        <li>
                            <a href=""><i class="fa fa-desktop "></i>Reserva<span class="fa arrow"></span></a>   
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
                            <h1 class="page-head-line">DASHBOARD</h1>
                            <h1 class="page-subhead-line"> </h1>

                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <div class="row"> 
                        <div class="row text-center pad-row">

                            <div class="col-md-3">
                                <div class="panel normal-table panel-danger adjust-border-radius">
                                    <div class="panel-heading adjust-border">
                                        <h4>BASIC PLAN</h4>
                                    </div>
                                    <div class="panel-body">

                                        <ul class="plan">
                                            <li class="price"><strong>S/. 25</strong><i class="fa fa-dollar"></i><small>al mes</small></li>
                                            <p>ESTE PLAN SOLO SE PUEDE COMPRAR UNA VEZ. Este plan es para 1 mes &uacute;nicamente y no se puede adquirir 2 o m&aacute;s veces. &Uacute;nicamente para nuevos afiliados. </p>
                                        </ul>
                                    </div>
                                    <div class="panel-footer">
                                        <a href="#" class="btn btn-danger btn-block btn-lg adjust-border-radius">Contratar</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="panel normal-table panel-primary adjust-border-radius">
                                    <div class="panel-heading adjust-border">
                                        <h4>MEDIUM PLAN</h4>
                                    </div>
                                    <div class="panel-body">

                                        <ul class="plan">
                                            <li class="price"><strong>S/. 45</strong> <i class="fa fa-dollar"></i><small>al mes</small></li>

                                        </ul>
                                    </div>
                                    <div class="panel-footer">
                                        <a href="#" class="btn btn-primary btn-block btn-lg adjust-border-radius">Contratar</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="panel normal-table panel-success adjust-border-radius">
                                    <div class="panel-heading adjust-border">
                                        <h4>ADVANCE PLAN</h4>
                                    </div>
                                    <div class="panel-body">

                                        <ul class="plan">
                                            <li class="price"><strong>S/. 95</strong> <i class="fa fa-dollar"></i><small>al mes</small></li>

                                        </ul>
                                    </div>
                                    <div class="panel-footer">
                                        <a href="#" class="btn btn-success btn-block btn-lg adjust-border-radius">Contratar</a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="panel normal-table panel-warning adjust-border-radius">
                                    <div class="panel-heading adjust-border">
                                        <h4>ADVANCE PLAN</h4>
                                    </div>
                                    <div class="panel-body">

                                        <ul class="plan">
                                            <li class="price"><strong>S/. 195</strong> <i class="fa fa-dollar"></i><small>al mes</small></li>

                                        </ul>
                                    </div>
                                    <div class="panel-footer">
                                        <a href="#" class="btn btn-warning btn-block btn-lg adjust-border-radius">Contratar</a>
                                    </div>
                                </div>
                            </div>

                        </div>



                    </div>
                    <!-- /. ROW  -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-12">

                                    <div id="reviews" class="carousel slide" data-ride="carousel">

                                        <div class="carousel-inner">
                                            <div class="item active">

                                                <div class="col-md-10 col-md-offset-1">

                                                    <h4><i class="fa fa-quote-left"></i>Los obstáculos no tienen que frenarte. Si te encuentras con una pared, no das la vuelta y abandonas. Encuentras la manera de subir a ella, pasar a través de ella o rodearla. <i class="fa fa-quote-right"></i></h4>
                                                    <div class="user-img pull-right">
                                                        <img src="assets/img/jordan.jpg" alt="" class="img-u image-responsive" /> 
                                                    </div>
                                                    <h5 class="pull-right"><strong class="c-black"> Michael Jordan</strong></h5>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="col-md-10 col-md-offset-1">

                                                    <h4><i class="fa fa-quote-left"></i> Si no tienes confianza, siempre encontrarás una forma de no ganar. <i class="fa fa-quote-right"></i></h4>
                                                    <div class="user-img pull-right">
                                                        <img src="assets/img/carl.jpg" alt="" class="img-u image-responsive" />
                                                    </div>
                                                    <h5 class="pull-right"><strong class="c-black"> Carl Lewis</strong></h5>
                                                </div>

                                            </div>
                                            <div class="item">
                                                <div class="col-md-10 col-md-offset-1">

                                                    <h4><i class="fa fa-quote-left"></i>No te rindas. Sufre ahora y vive el resto de tu vida como un campeón.<i class="fa fa-quote-right"></i></h4>
                                                    <div class="user-img pull-right">
                                                        <img src="assets/img/ali.jpg" alt="" class="img-u image-responsive" />
                                                    </div>
                                                    <h5 class="pull-right"><strong class="c-black">Muhammad Ali</strong></h5>
                                                </div>
                                            </div>
                                        </div>
                                        <!--INDICATORS-->
                                        <ol class="carousel-indicators">
                                            <li data-target="#reviews" data-slide-to="0" class="active"></li>
                                            <li data-target="#reviews" data-slide-to="1"></li>
                                            <li data-target="#reviews" data-slide-to="2"></li>
                                        </ol>
                                        <!--PREVIUS-NEXT BUTTONS-->

                                    </div>

                                </div>

                            </div>
                            <!-- /. ROW  -->
                            <hr />

                            <div class="panel panel-default">

                                <div id="carousel-example" class="carousel slide" data-ride="carousel" style="border: 5px solid #000;">

                                    <div class="carousel-inner">
                                        <div class="item active">

                                            <img src="assets/img/slideshow/img1.jpg" alt="" />

                                        </div>
                                        <div class="item">
                                            <img src="assets/img/slideshow/img2.jpg" alt="" />

                                        </div>
                                        <div class="item">
                                            <img src="assets/img/slideshow/img3.jpg" alt="" />

                                        </div>
                                    </div>
                                    <!--INDICATORS-->
                                    <ol class="carousel-indicators">
                                        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                        <li data-target="#carousel-example" data-slide-to="1"></li>
                                        <li data-target="#carousel-example" data-slide-to="2"></li>
                                    </ol>
                                    <!--PREVIUS-NEXT BUTTONS-->
                                    <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                        <span class="glyphicon glyphicon-chevron-left"></span>
                                    </a>
                                    <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                        <span class="glyphicon glyphicon-chevron-right"></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- /.REVIEWS &  SLIDESHOW  -->
                        <div class="col-md-4">


                        </div>
                        <!--/.Chat Panel End-->
                    </div>
                    <!-- /. ROW  -->


                    <div class="row">

                        <div class="col-md-12">

                            <br />
                            <!-- 16:9 aspect ratio -->
                            <div class="embed-responsive embed-responsive-16by9">
                                <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/xSI2uxfLxE0"></iframe> 
                            </div>
                        </div>

                    </div>
                    <!--/.Row-->
                    <hr />

                    <!--/.Row-->
                    <hr />

                    <!--/.ROW-->

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


        <!-- Código de instalación Cliengo para  www.google.com -->
        <script type="text/javascript">(function () {
                var ldk = document.createElement('script');
                ldk.type = 'text/javascript';
                ldk.async = true;
                ldk.src = 'https://s.cliengo.com/weboptimizer/60bc23e93a77dd002aeda352/60bc37d7ade1d5002a3d0ecc.js?platform=onboarding_modular';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ldk, s);
            })();</script>
    </body>
</html>
