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
                                            <input class="form-control" type="email" id="email" name="email"  required>
                                                <span style="color:red" class="form_error" id="invalid_email">Ingrese un correo válido </span>
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" type="password" id="password" name="password" pattern="[A-Za-z][A-Za-z0-9]*[0-9][A-Za-z0-9]*" title="Una contraseña válida es un conjuto de caracteres, donde cada uno consiste de una letra mayúscula o minúscula, o un dígito. La contraseña debe empezar con una letra y contener al menor un dígito" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Confirma Password </label>
                                            <input class="form-control" type="password" id="password2" name="password2" pattern="[A-Za-z][A-Za-z0-9]*[0-9][A-Za-z0-9]*" title="Una contraseña válida es un conjuto de caracteres, donde cada uno consiste de una letra mayúscula o minúscula, o un dígito. La contraseña debe empezar con una letra y contener al menor un dígito" required>
                                        </div>

                                        <button type="submit" id="submit"value class="btn btn-danger">Registrar</button>

                                </form>
                            </div>
                        </div>


                    </div>


                </div>

        </div>
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

                console.log("Entra");
                console.log("Entra 2");
                $('.form_error').hide();
                $('#submit').click(function () {
                    var email = $('#email').val();
                    console.log("correo " + $('#email').val());

                    if (IsEmail(email) == false) {
                        $('#invalid_email').show();
                        return false;
                    }
                });

                $("#email").focus(function () {
                    $('.form_error').hide();
                });
            });

            function IsEmail(email) {
                var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                if (!regex.test(email)) {
                    return false;
                } else {
                    return true;
                }
            }
        </script>

    </body>
</html>
