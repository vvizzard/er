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
                                <h3>Historique Projet</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Projets</h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        <form method="get" action="rechercheHistoriqueProjet">
                                            <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                <div class="row">

                                                    <div class="col-md-2">
                                                        Reference bon
                                                        <input type="text" name="refBon" value="<s:property value="%{refBon}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Demandeur
                                                        <input type="text" name="demandeur" value="<s:property value="%{demandeur}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Projet
                                                        <input type="text" name="projet" value="<s:property value="%{projet}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Type<br>
                                                        <select name="type" style="width: 88%; height: 26px;">
                                                            <option<s:if test="%{type!=entree&&type!=sortie}"> selected="true" </s:if>>Tout</option>
                                                            <option<s:if test="%{type==entree}"> selected="true" </s:if>>Entree</option>
                                                            <option<s:if test="%{type==sortie}"> selected="true" </s:if>>Sortie</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-2">
                                                            Article
                                                            <input type="text" name="article" value="<s:property value="%{article}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Facture
                                                        <input type="text" name="facture" value="<s:property value="%{facture}"/>">
                                                    </div>
                                                </div>
                                                <div class="row">                                                
                                                    <div class="col-md-2">
                                                        Date entre
                                                        <input type="date" name="debut" value="<s:property value="%{debut}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        et<br>
                                                        <input type="date" name="fin" value="<s:property value="%{fin}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Nombre min
                                                        <input type="number" step="0.01" name="nbrMin" value="<s:property value="%{nbrMin}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Nombre max
                                                        <input type="number" step="0.01" name="nbrMax" value="<s:property value="%{nbrMax}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Valeur min
                                                        <input type="number" step="0.01" name="valeurMin" value="<s:property value="%{valeurMin}"/>">
                                                    </div>
                                                    <div class="col-md-2">
                                                        Valeur max
                                                        <input type="number" step="0.01" name="valeurMax" value="<s:property value="%{valeurMax}"/>">
                                                    </div>                                                                                                
                                                </div>                                                
                                                <div class="row">
                                                    <div class="col-md-10"></div>
                                                    <div class="col-md-2">
                                                        <br>
                                                        <input type="submit" value="Rechercher" style="width: 90%;">
                                                    </div>
                                                </div>
                                                <div class="row">                                                    
                                                    <div class="x_title">                                                    
                                                        <div class="clearfix"></div>
                                                    </div>
                                                    <!--                                                        <script>
                                                                                                                jQuery(document).ready(function ($) {
                                                                                                                    $(".clickable-row").click(function () {
                                                                                                                        window.location = $(this).data("href");
                                                                                                                    });
                                                                                                                });
                                                                                                            </script>-->
                                                    <div class="col-sm-12">
                                                        <div class="table-responsive">
                                                            <table class="table table-striped jambo_table bulk_action">
                                                                <thead>
                                                                    <tr class="headings">
                                                                        <th class="column-title">Id </th>
                                                                        <th class="column-title">Demandeur</th>                                                                    
                                                                        <th class="column-title">Projet</th>
                                                                        <th class="column-title">Type</th>
                                                                        <th class="column-title">Date</th>
                                                                        <th class="column-title">Facture</th>
                                                                        <th class="column-title">Article</th>
                                                                        <th class="column-title">Nombre</th>
                                                                        <th class="column-title">Valeur</th>
                                                                        <th class="column-title">Justification</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="listeHistorique">
                                                                        <tr class="odd pointer clickable-row" data-href='listeBon?idProjet=<s:property value="getId()"></s:property>'>                                                                        
                                                                            <td><s:property value="getId()" /></td>
                                                                            <td><s:property value="getNom()+' '+getPrenom()" /></td>                                                                        
                                                                            <td><s:if test="%{getType()!='entree'}"><s:property value="getProjet()" /></s:if></td>
                                                                            <td><s:property value="getType()" /></td>                                                                        
                                                                            <td><s:property value="getDateString()" /></td>
                                                                            <td><s:property value="getFacture()" /></td>
                                                                            <td><s:property value="getArticle()" /></td>
                                                                            <td><s:property value="getNombre()" /></td>
                                                                            <td><s:property value="getPrixt()" /></td>
                                                                            <td><s:property value="getPhoto()" /></td>
                                                                        </tr>
                                                                    </s:iterator>                                                                        
                                                                </tbody>
                                                            </table>                                                            
                                                            <ul class="pagination">                                                                
                                                                <s:iterator value="nbrPage" status="inc">
                                                                    <s:if test="%{page==nbrPage.get(#inc.index)}">
                                                                        <li class="active"><a href="rechercheHistoriqueProjet?refBon=<s:property value="%{refBon}"/>&demandeur=<s:property value="%{demandeur}"/>&projet=<s:property value="%{projet}"/>&type=<s:property value="%{type}"/>&article=<s:property value="%{article}"/>&facture=<s:property value="%{facture}"/>&debut=<s:property value="%{debut}"/>&fin=<s:property value="%{fin}"/>&nbrMin=<s:property value="%{nbrMin}"/>&nbrMax=<s:property value="%{nbrMax}"/>&valeurMin=<s:property value="%{valeurMin}"/>&valeurMax=<s:property value="%{valeurMax}"/>&page=<s:property/>"><s:property/></a></li>
                                                                        </s:if>
                                                                        <s:else>
                                                                        <li><a href="rechercheHistoriqueProjet?refBon=<s:property value="%{refBon}"/>&demandeur=<s:property value="%{demandeur}"/>&projet=<s:property value="%{projet}"/>&type=<s:property value="%{type}"/>&article=<s:property value="%{article}"/>&facture=<s:property value="%{facture}"/>&debut=<s:property value="%{debut}"/>&fin=<s:property value="%{fin}"/>&nbrMin=<s:property value="%{nbrMin}"/>&nbrMax=<s:property value="%{nbrMax}"/>&valeurMin=<s:property value="%{valeurMin}"/>&valeurMax=<s:property value="%{valeurMax}"/>&page=<s:property/>"><s:property/></a></li>
                                                                        </s:else> 
                                                                    </s:iterator>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                        <input type="hidden" name="page" value="<s:property value="%{page}"/>">
                                        <br>
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