<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Entreprise RANDRIANARISOA</title>

        <!-- Bootstrap -->
        <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-wysiwyg -->
        <link href="vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
        <!-- Select2 -->
        <link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet">
        <!-- Switchery -->
        <link href="vendors/switchery/dist/switchery.min.css" rel="stylesheet">
        <!-- starrr -->
        <link href="vendors/starrr/dist/starrr.css" rel="stylesheet">
        <!-- bootstrap-daterangepicker -->
        <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="build/css/custom.min.css" rel="stylesheet">

        <script>
            (function (e, t, n) {
                var r = e.querySelectorAll("html")[0];
                r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2");
            })(document, window, 0);
        </script>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <%@include file="header.jsp"%>


                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Utilisateur</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="addUser" method="POST" enctype="multipart/form-data">                                        
                                        <div class="x_content" style="margin-top: -15px;">
                                            <br />
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <div class="x_panel">
                                                        <div class="x_title">
                                                            <h2>Ajout/Modification</h2>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                        <div class="x_content" style="margin-top: -15px;">
                                                            <br />  
                                                            <s:if test="%{getError()!=''}"><p style="color: red;" class="form-control">Compte existant!</p></s:if>
                                                                <div class="clearfix"></div>
                                                                <div class="ln_solid"></div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" >Nom <span class="required">*</span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="nom" value="<s:property value="%{nom}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" >Prenom <span class="required"></span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="prenom" value="<s:property value="%{prenom}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>                                                                
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="Date de naissance">Date de naissance <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="date" id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="dateNaissance" value="<s:property value="%{dateNaissance}"></s:property>">
                                                                    </div>
                                                                </div> 
                                                                <div class="form-group">
                                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="CIN">CIN <span class="required">*</span>
                                                                    </label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="cin" value="<s:property value="%{cin}"></s:property>">
                                                                    </div>
                                                                </div>                                                                
                                                                <div class="clearfix"></div>
                                                                <div class="ln_solid"></div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" >Matricule <span class="required"></span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="matricule" value="<s:property value="%{matricule}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Date d'embauche <span class="required"></span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <input type="date" id="first-name" class="form-control col-md-7 col-xs-12" name="dateEmbauche" value="<s:property value="%{dateEmbauche}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" >Accès <span class="required"></span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                        <select id="first-name" class="form-control col-md-7 col-xs-12" name="departement">                                                                            
                                                                        <s:iterator value="departements">
                                                                            <s:if test="getDesignation()==getDepartement()">
                                                                                <option value="<s:property value="getDesignation()" />" selected ><s:property value="getDesignation()" /></option>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <option value="<s:property value="getDesignation()" />"><s:property value="getDesignation()" /></option>
                                                                            </s:else>
                                                                        </s:iterator>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <%--<s:if test="getId()==0||getMine()!=0">--%>
                                                            <div class="clearfix"></div>
                                                            <div class="ln_solid"></div>
                                                            <div class="form-group">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Identifiant <span class="required"></span></label>
                                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                                    <input type="text" id="first-name" <s:if test="%{getError()!=''}">style = "border-color: red;"</s:if> class="form-control col-md-7 col-xs-12" name="identifiant" value="<s:property value="%{identifiant}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Mot de passe <span class="required"></span></label>
                                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                                            <input type="password" <s:if test="%{getError()!=''}">style = "border-color: red;"</s:if> id="first-name" class="form-control col-md-7 col-xs-12" name="pw" value="<s:property value="%{pw}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                            <%--</s:if>--%>
                                                            <s:hidden name="id" value="%{id}"></s:hidden>
                                                            </div>
                                                            <div class="clearfix"></div>
                                                            <div class="ln_solid"></div>
                                                            <button class="btn btn-primary col-md-offset-7" type="submit" >Enregistrer</button>
                                                            <a href="listeUser"><button class="btn btn-danger" type="button">Annuler</button></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                        </form>
                                    </div>                                    
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- /page content -->

                <!-- footer content -->
            <%@include file="footer.jsp"%>
            <!-- /footer content -->
        </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="vendors/moment/min/moment.min.js"></script>
    <script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>

    <script src="vue/js/custom-file-input.js"></script>

    <script>
            jQuery(document).ready(function ($) {
                $(".clickable-row").click(function () {
                    window.location = $(this).data("href");
                });
                $(".goFamille").click(function () {
                    window.location = $(this).data("href");
                });
                $(".add").click(function () {
                    window.location = "ajouterSortie?codeDernierFamille=" + $('[name="codeDernierFamille"]').val() + "&unite=" + $('[name="unite"]').val() + "&nombre=" + $('[name="nombre"]').val() + "&coms=" + $('[name="coms"]').val() + "&idDernierFamille=" + $('[name="idDernierFamille"]').val() + "&idDernierProjet=" + $('[name="idDernierProjet"]').val();
                });
                $(".del").click(function () {
                    window.location = $(this).data("href");
                });
            });
    </script>

</body>

</html>