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
                                <h3>Nouvel Article</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="addArticle" method="POST" enctype="multipart/form-data">
                                        <div class="x_title">
                                            <div class="col-md-7 col-sm-7">
                                                <h2>Details</h2>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content" style="margin-top: -15px;">
                                            <br />
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <div class="x_panel">
                                                        <div class="x_title">
                                                            <h2>Articles</h2>
                                                            <div class="clearfix"></div>
                                                        </div>

                                                        <div class="x_content" style="margin-top: -15px;">
                                                            <br />                                                            
                                                            <div class="clearfix"></div>
                                                            <div class="ln_solid"></div>

                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Code <span class="required">*</span></label>
                                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                    <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="codeArticle" value="<s:property value="%{codeArticle}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Designation <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="designation" value="<s:property value="%{designation}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Famille <span class="">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group"> 
                                                                        <select id="first-name" class="form-control col-md-7 col-xs-12" name="designationFamille">
                                                                        <s:iterator value="getFamilles()">
                                                                            <s:if test="%{designation==getDesignationFamille()}">
                                                                                <option value="<s:property value="getDesignation()" />" selected><s:property value="getDesignation()" /></option>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <option value="<s:property value="getDesignation()" />"><s:property value="getDesignation()" /></option>
                                                                            </s:else>
                                                                        </s:iterator>                                                                                                                                                                    
                                                                    </select>
                                                                </div>
                                                            </div> 
                                                            <input type="hidden" name="idArticle" value="<s:property value="getIdArticle()"/>">
                                                            <!--                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                                                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Fournisseur <span class="">*</span></label>
                                                                                                                            <div class="col-md-10 col-sm-10 col-xs-12 input-group"> 
                                                                                                                                <select id="first-name" class="form-control col-md-7 col-xs-12" name="designationFournisseur">
                                                            <s:iterator value="getFournisseurs()">                                                                                
                                                                <option value="<s:property value="getNom()" />"><s:property value="getNom()" /></option>
                                                            </s:iterator>                                                                                                                                                                    
                                                        </select>
                                                    </div>
                                                </div>-->
                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Unité(Defaut) <span class="">*</span></label>
                                                                <div class="col-md-10 col-sm-10 col-xs-12 input-group"> 
                                                                    <select id="first-name" class="form-control col-md-7 col-xs-12" name="designationUnite">
                                                                        <s:iterator value="getUnites()">
                                                                            <s:if test="%{designation==getDesignationUnite()}">
                                                                                <option value="<s:property value="getDesignation()" />" selected><s:property value="getDesignation()" /></option>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <option value="<s:property value="getDesignation()" />"><s:property value="getDesignation()" /></option>
                                                                            </s:else>
                                                                        </s:iterator>                                                                                                                                                                    
                                                                    </select>
                                                                </div>
                                                            </div> 
                                                            <!--                                                            <div class="form-group" style="margin-bottom: -9px;">
                                                                                                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Prix <span class="required">*</span></label>
                                                                                                                            <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                                                                                <input type="number" id="first-name" class="form-control col-md-7 col-xs-12" name="prix" value="<s:property value="%{prix}"></s:property>">                                                                            
                                                                                                                            </div>
                                                                                                                        </div>                                                                                                                                   -->
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">SM <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="number" id="first-name" class="form-control col-md-7 col-xs-12" name="sm" step="0.01" value="<s:property value="%{sm}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">SA <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="number" id="first-name" class="form-control col-md-7 col-xs-12" name="sa" step="0.01" value="<s:property value="%{sa}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">SS <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="number" id="first-name" class="form-control col-md-7 col-xs-12" name="limite" step="0.01" value="<s:property value="%{limite}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Emplacement <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="emplacement" value="<s:property value="%{emplacement}"></s:property>">                                                                            
                                                                    </div>
                                                                </div>

                                                            </div>

                                                            <button class="btn btn-primary col-md-offset-9" type="submit" >Enregistrer</button>
                                                            <a href="listeArticle"><button class="btn btn-danger" type="button">Annuler</button></a>


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
                $(".goArticle").click(function () {
                    window.location = $(this).data("href");
                });
                $(".add").click(function () {
                    window.location = "ajouterSortie?codeDernierArticle=" + $('[name="codeDernierArticle"]').val() + "&unite=" + $('[name="unite"]').val() + "&nombre=" + $('[name="nombre"]').val() + "&coms=" + $('[name="coms"]').val() + "&idDernierArticle=" + $('[name="idDernierArticle"]').val() + "&idDernierProjet=" + $('[name="idDernierProjet"]').val();
                });
            });
    </script>

</body>

</html>