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
                                <h3>Fiche article</h3>
                            </div>                            
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Details <small>article</small></h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Settings 1</a>
                                                    </li>
                                                    <li><a href="#">Settings 2</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">                                                                                        
                                            <ul class="list-unstyled user_data">
                                                <li>
                                                    <label style="width:52px;">Nom: </label><b><s:property value="article.getDesignation()"/></b>
                                                </li>

                                                <li>
                                                    <label style="width:52px;">Ref: </label><s:property value="article.getCode()"/>
                                                </li>

                                                <li>
                                                    <label style="width:52px;">Famille: </label><s:property value="article.getFamille().getDesignation()"/>
                                                </li>

                                                <li class="m-top-xs">
                                                    <label style="width:52px;">Unitée: </label><s:property value="article.getUnite().getDesignation()"/> 
                                                </li>
                                            </ul>
                                            <br />
                                        </div>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <!-- start user projects -->
                                            <table class="data table table-striped no-margin">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Fournisseur</th>
                                                        <th>Prix</th>                                                                    
                                                    </tr>
                                                </thead>                                                
                                                <tbody>
                                                    <s:iterator value="listeFournisseursPrix">
                                                        <tr>
                                                            <td><s:property value="getId()"/></td>
                                                            <td><s:property value="getFournisseur()"/></td>
                                                            <td><s:property value="getMontant()"/></td>      
                                                            <td style="padding: 0px;"><i class=" btn btn-xs fa fa-trash-o fa-2x del" data-href="deleteFournisseurArticle?idFournisseurArticle=<s:property value="getId()"></s:property>&idArticle=<s:property value="getIdArticle()"></s:property>"></i></td>
                                                        </tr>
                                                    </s:iterator>                                                                                                        
                                                </tbody>
                                            </table>
                                            <!-- end user projects -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="x_content" style="margin-top: -15px;">
                        <br />
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Fournisseurs</h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <form action="addFourisseurArticle" method="post">
                                        <div class="x_content" style="margin-top: -15px;">
                                            <br />                                                            
                                            <div class="clearfix"></div>
                                            <div class="ln_solid"></div>                                        

                                            <div class="form-group" style="margin-bottom: -9px;">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Fournisseurs <span class="">*</span></label>
                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group"> 
                                                    <select id="first-name" class="form-control col-md-7 col-xs-12" name="fournisseurT">
                                                        <s:iterator value="getFournisseurs()">
                                                            <option value="<s:property value="getNom()" />"><s:property value="getNom()" /></option>
                                                        </s:iterator>                                                                                                                                                                    
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-bottom: -9px;">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Prix unitaire <span class="required">*</span></label>
                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                    <input type="number" id="first-name" class="form-control col-md-7 col-xs-12" name="prixT" value="<s:property value="%{prixT}"></s:property>">                                                                            
                                                    </div>
                                                </div>
                                            </div>
                                        <s:hidden name="idArticle" value="%{idArticle}"/>
                                        <button class="btn btn-primary col-md-offset-9" type="submit" >Ajouter</button>
                                        <a href="listeArticle"><button class="btn btn-danger" type="button">Annuler</button></a>
                                    </form>
                                </div>
                            </div>
                        </div>
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
                $(".goArticle").click(function () {
                    window.location = $(this).data("href");
                });
                $(".del").click(function () {
                    window.location = $(this).data("href");
                });
                $(".add").click(function () {
                    window.location = "ajouterSortie?codeDernierArticle=" + $('[name="codeDernierArticle"]').val() + "&unite=" + $('[name="unite"]').val() + "&nombre=" + $('[name="nombre"]').val() + "&coms=" + $('[name="coms"]').val() + "&idDernierArticle=" + $('[name="idDernierArticle"]').val() + "&idDernierProjet=" + $('[name="idDernierProjet"]').val();
                });
            });
        </script>        
    </body>

</html>