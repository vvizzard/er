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
                                <h3>Fournisseur</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="addFournisseur" method="POST" enctype="multipart/form-data">                                        
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
                                                            <div class="clearfix"></div>
                                                            <div class="ln_solid"></div>
                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Nom <span class="required">*</span></label>
                                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                    <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="nom" value="<s:property value="%{nom}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                    <div class="form-group" style="margin-bottom: -9px;">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Contact
                                                                    <span class="required"></span></label>
                                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                    <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="contacte" value="<s:property value="%{contacte}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Emplacement<span class="required"></span></label>
                                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                    <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="emplacement" value="<s:property value="%{emplacement}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                            <s:hidden name="idFournisseur" value="%{idFournisseur}"></s:hidden>
                                                            </div>
                                                            <button class="btn btn-primary col-md-offset-9" type="submit" >Enregistrer</button>
                                                            <button class="btn btn-danger" type="button">Annuler</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                        </form>
                                    </div>
                                    <div class="x_panel">                                    
                                        <div class="x_content" style="margin-top: -15px;">
                                            <br />
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <div class="x_panel">
                                                        <div class="x_title">
                                                            <h2>Liste</h2>
                                                            <div class="clearfix"></div>
                                                        </div>                                                        
                                                        <div class="col-sm-12">
                                                            <div class="table-responsive">
                                                                <table class="table table-striped jambo_table bulk_action">
                                                                    <thead>
                                                                        <tr class="headings">
                                                                            <th class="column-title">Id </th>
                                                                            <th class="column-title">Nom</th>                                                                            
                                                                            <th class="column-title">Emplacement </th>
                                                                            <th class="column-title">Contact </th>
                                                                            <th></th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <s:iterator value="listeFournisseur">
                                                                        <tr class="odd pointer">                                                                        
                                                                            <td class="clickable-row" data-href='etatFournisseur?idFournisseur=<s:property value="getId()"></s:property>&nom=<s:property value="getNom()"></s:property>&emplacement=<s:property value="getEmplacement()"></s:property>&contacte=<s:property value="getContacte()"></s:property>'><s:property value="getId()" /></td>
                                                                            <td class="clickable-row" data-href='etatFournisseur?idFournisseur=<s:property value="getId()"></s:property>&nom=<s:property value="getNom()"></s:property>&emplacement=<s:property value="getEmplacement()"></s:property>&contacte=<s:property value="getContacte()"></s:property>'><s:property value="getNom()" /></td>
                                                                            <td class="clickable-row" data-href='etatFournisseur?idFournisseur=<s:property value="getId()"></s:property>&nom=<s:property value="getNom()"></s:property>&emplacement=<s:property value="getEmplacement()"></s:property>&contacte=<s:property value="getContacte()"></s:property>'><s:property value="getEmplacement()" /></td>                                                                            
                                                                            <td class="clickable-row" data-href='etatFournisseur?idFournisseur=<s:property value="getId()"></s:property>&nom=<s:property value="getNom()"></s:property>&emplacement=<s:property value="getEmplacement()"></s:property>&contacte=<s:property value="getContacte()"></s:property>'><s:property value="getContacte()" /></td>                                                                            
                                                                            <td style="padding: 0px;"><button class="btn btn-danger del" data-href="deleteFournisseur?idFournisseur=<s:property value="getId()"></s:property>" type="button">Supprimer</button></td>
                                                                        </tr>
                                                                    </s:iterator>                                                                        
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br>                                    
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
                $(".del").click(function () {
                    window.location = $(this).data("href");
                });
            });
    </script>

</body>

</html>