<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Responsive Bootstrap Advance Admin Template</title>

        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

    </head>
    <body style="background-image: url(assets/img/fondo.jpg)">
        <div class="container">
            <div class="row text-center " style="padding-top:100px;">
                <div class="col-md-12">
                    <img src="assets/img/login.jpg" />
                </div>
            </div>
            <div class="row ">

                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

                    <div class="panel-body">
                        
                        <form role="form" action="usuariocontroller.do" method="post">
                            <hr />
                            <!--<h5>Enter Details to Login</h5>-->
                            <input type="hidden" name="txtProceso" value="login">
                            <br />
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                <input type="text" class="form-control" id="txtCorreo"  name="txtCorreo" placeholder="Your Email " 
                                       oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required=""/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>                     
                                <input type="password" class="form-control" id="txtClave" name="txtClave" placeholder="Your Password" 
                                       oninvalid="InvalidMsg(this);" oninput="InvalidMsg(this);" required/>
                            </div>
                            <div class="form-group">
                                <label class="checkbox-inline">
                                    <input type="checkbox" /> Remember me
                                </label>
                                <span class="pull-right">
                                  <!--  <a href="index.html" >Forget password ? </a>  -->
                                </span>
                            </div>

                            <!-- <a href="index.html" class="btn btn-primary ">Login Now</a> -->
                             <button type="submit" class="btn btn-lg btn-primary">Iniciar Sesion</button>
                            <hr />
                            Nuevo registro ? <a href="nuevo_usuario.jsp" >click here </a> 
                        </form>
                    </div>

                </div>


            </div>
        </div>

    </body>
</html>
