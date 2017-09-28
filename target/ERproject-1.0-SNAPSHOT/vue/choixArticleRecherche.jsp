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
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Liste des articles</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Entrée |<small>choix de l'article</small></h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <form method="get" action="rechercheArticle">
                                            <br />
                                            <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-6">
                                                        <div id="datatable_filter" class="dataTables_filter">
                                                            <select class="form-control input-sm" name="searchFamille" placeholder="Categorie" aria-controls="datatable">
                                                                <option>Famille</option>
                                                                <s:iterator value="listeFamille" status="inc">
                                                                    <s:if test="%{searchFamille==listeFamille.get(#inc.index)}">
                                                                        <option selected="true"><s:property/></option>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <option><s:property/></option>
                                                                    </s:else>
                                                                </s:iterator>
                                                            </select>
                                                            <select class="form-control input-sm" name="searchEmplacement" placeholder="Emplacement" aria-controls="datatable">
                                                                <option>Emplacement</option>
                                                                <s:iterator value="listeEmplacement" status="inc">
                                                                    <s:if test="%{searchEmplacement==listeEmplacement.get(#inc.index)}">
                                                                        <option selected="true"><s:property/></option>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <option><s:property/></option>
                                                                    </s:else>
                                                                </s:iterator>
                                                            </select>
                                                        </div>
                                                        <div id="datatable_filter" class="dataTables_filter"><label><input type="search" name="critere" class="form-control input-sm" value="<s:property value="critere"/>" placeholder="Rechercher" aria-controls="datatable"></label></div>
                                                    </div>
                                                </div>
                                                <div class="row">
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
                                                    <s:hidden name="idDemandeur" value="%{idDemandeur}"></s:hidden>
                                                        <div class="col-sm-12">
                                                            <div class="table-responsive">
                                                                <table class="table table-striped jambo_table bulk_action">
                                                                    <thead>
                                                                        <tr class="headings">
                                                                            <th class="column-title">Id </th>
                                                                            <th class="column-title">Reference</th>
                                                                            <th class="column-title">Designation </th>
                                                                            <th class="column-title">Famille </th>
                                                                            <th class="column-title">Unitée </th>
                                                                            <th class="column-title">Limite </th>
                                                                            <th class="column-title">Emplacement </th>
                                                                            <!--<th class="column-title" style="text-align: right;">Prix unitaire </th>-->
                                                                            <th></th>
                                                                            <th></th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <s:iterator value="listeArticle">
                                                                        <s:if test="%{type == 1}">
                                                                            <tr class="odd pointer">
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getId()" /></td>
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getCode()" /></td> 
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getDesignation()" /></td>                         
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getFamille()" /></td>
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getUnite()" /></td>
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getLimite()" /></td>                         
                                                                                <td class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getEmplacement()" /></td>                                                                                                                                                                       
                                                                                </tr>
                                                                        </s:if>
                                                                        <s:elseif test="%{type == -1}">
                                                                            <tr class="odd pointer">
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getId()" /></td>
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getCode()" /></td> 
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getDesignation()" /></td>                         
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getFamille()" /></td>      
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getUnite()" /></td>
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getLimite()" /></td>                         
                                                                                <td class="clickable-row" data-href='ajoutArticleSortie?idDernierArticle=<s:property value="getId()"></s:property>&idDemandeur=<s:property value="idDemandeur()"></s:property>' ><s:property value="getEmplacement()" /></td>                                                                                           
                                                                                </tr>
                                                                        </s:elseif>
                                                                        <s:else>
                                                                            <tr class="odd pointer">
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getId()" /></td>
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getCode()" /></td> 
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getDesignation()" /></td>                         
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getFamille()" /></td>         
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getUnite()" /></td>
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getLimite()" /></td>                         
                                                                                <td class="clickable-row" data-href='newArticle?idArticle=<s:property value="getId()"></s:property>' ><s:property value="getEmplacement()" /></td>               

                                                                                    <td style="padding: 0px;"><i class=" btn btn-xs fa fa-trash-o fa-2x del" data-href="deleteArticle?idArticle=<s:property value="getId()"></s:property>"></i></td>
                                                                                <td style="padding: 0px;"><i class=" btn btn-xs fa fa-angle-double-right fa-2x del" data-href="ficheArticle?idArticle=<s:property value="getId()"></s:property>"></i></td>
                                                                                </tr>
                                                                        </s:else>                                                                            
                                                                    </s:iterator>                                                                        
                                                                </tbody>
                                                            </table>                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <s:hidden name="type" value="%{type}"></s:hidden>
                                            <input type="submit" style="display: none">
                                        </form>
                                    </div>
                                </div>
                            </div>
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