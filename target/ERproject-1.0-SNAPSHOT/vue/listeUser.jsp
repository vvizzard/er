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
        <!-- jQuery -->
        <script src="vendors/jquery/dist/jquery.min.js"></script>
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
                                <h3>Utilisateurs</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Liste des utilisateurs</h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        <form method="get" action="rechercheUser">
                                            <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-6">
                                                        <div id="datatable_filter" class="dataTables_filter">
                                                            <select class="form-control input-sm" placeholder="Categorie" name="departement" aria-controls="datatable">
                                                                <option>Departement</option>
                                                                <s:iterator value="departements" status="inc">
                                                                    <s:if test="%{departement==departements.get(#inc.index).getDesignation()}">
                                                                        <option selected="true"><s:property value="getDesignation()"/></option>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <option><s:property value="getDesignation()"/></option>
                                                                    </s:else>
                                                                </s:iterator>
                                                            </select>                                                        
                                                        </div>
                                                        <div id="datatable_filter" class="dataTables_filter"><label>Rechercher: <input name="critere" value="<s:property value="%{critere}"/>" type="search" class="form-control input-sm" placeholder="" aria-controls="datatable"></label></div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <script>
                                                        jQuery(document).ready(function ($) {
                                                            $(".clickable-row").click(function () {
                                                                window.location = $(this).data("href");
                                                            });
                                                        });
                                                    </script>
                                                    <div class="col-sm-12">
                                                        <div class="table-responsive">
                                                            <table class="table table-striped jambo_table bulk_action">
                                                                <thead>
                                                                    <tr class="headings">
                                                                        <th class="column-title">Matricule </th>
                                                                        <th class="column-title">Nom</th>
                                                                        <th class="column-title">Prenom </th>
                                                                        <th class="column-title">Date de naissance</th>
                                                                        <th class="column-title">CIN</th>
                                                                        <th class="column-title">Acces</th>       
                                                                        <th></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:if test="getType()==1">
                                                                        <s:iterator value="listeUser">
                                                                            <tr>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getMatricule()" /></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getNom()" /></td> 
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getPrenom()" /></td>  
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getDateNaissanceString()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getCin()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeur?idDemandeur=<s:property value="getId()" />'><s:property value="getDepartement().getDesignation()" /></td>                                                                                
                                                                            </tr>
                                                                        </s:iterator>                                                                        
                                                                    </s:if>
                                                                    <s:elseif test="getType()==-1">
                                                                        <s:iterator value="listeUser">
                                                                            <tr>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getMatricule()" /></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getNom()" /></td> 
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getPrenom()" /></td>  
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getDateNaissanceString()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getCin()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='ajoutDemandeurSortie?idDemandeur=<s:property value="getId()" />'><s:property value="getDepartement().getDesignation()" /></td>                                                                        
                                                                            </tr>
                                                                        </s:iterator>                                                                        
                                                                    </s:elseif>
                                                                    <s:else>
                                                                        <s:iterator value="listeUser">
                                                                            <tr>
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getMatricule()" /></td>
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getNom()" /></td> 
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getPrenom()" /></td>  
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getDateNaissanceString()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getCin()"/></td>
                                                                                <td class="odd pointer clickable-row" data-href='loadUser?id=<s:property value="getId()" />'><s:property value="getDepartement().getDesignation()" /></td>                                                                        
                                                                                <td style="padding: 0px;"><i class=" btn btn-xs fa fa-trash-o fa-2x del clickable-row" data-href="deleteUser?id=<s:property value="getId()"></s:property>"></i></td>
                                                                                </tr>
                                                                        </s:iterator>
                                                                    </s:else>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <input type="submit" style="display: none">
                                        </form>
                                        <br>
                                    </div>
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

    </body>

</html>