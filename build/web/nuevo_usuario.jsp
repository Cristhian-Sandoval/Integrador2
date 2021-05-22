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
            <br>
            <div class="row ">

                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

                   
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                Nuevo registro 
                            </div>
                            <div class="panel-body">
                                <form role="form" action="usuariocontroller.do">
                                     <input type="hidden" name="txtProceso" value="nuevo">

                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" type="text" id="email" name="email" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input class="form-control" type="password" id="password" name="password" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Confirma Password </label>
                                        <input class="form-control" type="password" id="password2" name="password2" required>
                                    </div>

                                    <button type="submit" class="btn btn-danger">Registrar</button>

                                </form>
                            </div>
                        </div>
                  

                </div>


            </div>

        </div>

    </body>
</html>
