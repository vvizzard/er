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
                                <h3>Inventaire</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">                                    
                                    <div class="row tile_count" style="margin-bottom: 20px; margin-top: 20px;">
                                        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count" >
                                            <h2>Etat de stock</h2>
                                        </div>                                        
                                        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count " style="margin-bottom: 0px; padding-bottom: 0px;text-align: right;">
                                            <span class="count_top"> Stock minimal</span>
                                            <s:if test="%{nbrSM!=0}"><a href="rechercheInventaire?typeFiltreS=sm&famille=Famille&emplacement=Emplacement&critere="><div class="count" style="text-align: right;"><s:property value="getNbrSM()"/></div></a></s:if><s:else><div class="count" style="text-align: right;"><s:property value="getNbrSM()"/></div></s:else>
                                            </div>
                                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count " style="margin-bottom: 0px; padding-bottom: 0px;text-align: right;">
                                                <span class="count_top"> Stock d'alerte</span>
                                            <s:if test="%{nbrSA!=0}"><a href="rechercheInventaire?typeFiltreS=sa&famille=Famille&emplacement=Emplacement&critere="><div class="count" style="text-align: right;"><s:property value="getNbrSA()"/></div></a></s:if><s:else><div class="count" style="text-align: right;"><s:property value="getNbrSA()"/></div></s:else>
                                            </div>
                                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count " style="margin-bottom: 0px; padding-bottom: 0px;text-align: right;">
                                                <span class="count_top"> Stock de sécurité</span>
                                            <s:if test="%{nbrSS!=0}"><a href="rechercheInventaire?typeFiltreS=ss&famille=Famille&emplacement=Emplacement&critere="><div class="count" style="text-align: right;"><s:property value="getNbrSS()"/></div></a></s:if><s:else><div class="count" style="text-align: right;"><s:property value="getNbrSS()"/></div></s:else>
                                            </div>
                                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count" style="margin-bottom: 0px; padding-bottom: 0px;text-align: right;">
                                                <span class="count_top"> Nombre totale</span>
                                                <a href="etatInventaire"><div class="count" style="text-align: right;"><s:property value="%{totalArticle}"/></div></a>
                                        </div>
                                        <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count" style="margin-bottom: 0px; padding-bottom: 0px;text-align: right;">
                                            <span class="count_top"><i class="fa fa-usd" aria-hidden="true"></i> Valeur de stock</span>
                                            <div class="count" style="text-align: right;"><s:property value="%{totalValeur}"/></div>
                                        </div>
                                    </div>   

                                    <div class="x_content">
                                        <form method="get" action="rechercheInventaire">
                                            <br />
                                            <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                <div class="row">
                                                    <div class="col-sm-6 col-sm-offset-6">
                                                        <div id="datatable_filter" class="dataTables_filter">
                                                            <select class="form-control input-sm" name="famille" placeholder="Categorie" aria-controls="datatable">
                                                                <option>Famille</option>
                                                                <s:iterator value="listeFamille" status="inc">
                                                                    <s:if test="%{famille==listeFamille.get(#inc.index)}">
                                                                        <option selected="true"><s:property/></option>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <option><s:property/></option>
                                                                    </s:else>
                                                                </s:iterator>
                                                            </select>
                                                            <select class="form-control input-sm" name="emplacement" placeholder="Emplacement" aria-controls="datatable">
                                                                <option>Emplacement</option>
                                                                <s:iterator value="listeEmplacement" status="inc">
                                                                    <s:if test="%{emplacement==listeEmplacement.get(#inc.index)}">
                                                                        <option selected="true"><s:property/></option>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <option><s:property/></option>
                                                                    </s:else>
                                                                </s:iterator>
                                                            </select>
                                                        </div>
                                                        <div id="datatable_filter" class="dataTables_filter"><label>Rechercher: <input type="search" class="form-control input-sm" placeholder="" name="critere" aria-controls="datatable" value="<s:property value="critere"/>"></label></div>                                                        
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
                                                            <table id="table" class="table table-striped jambo_table bulk_action">
                                                                <thead>
                                                                    <tr class="headings">
                                                                        <th class="column-title"> </th>
                                                                        <th class="column-title">Reference</th>
                                                                        <th class="column-title">Designation </th>
                                                                        <th class="column-title">Famille</th>
                                                                        <th class="column-title">Emplacement</th>
                                                                        <th class="column-title">Nombre </th>
                                                                        <th class="column-title">Unite </th>
                                                                        <th class="column-title" style="text-align: right;">Valeur </th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="listeInventaire">
                                                                        <tr class="odd pointer" id="tr<s:property value="getId()" />">                                                                        
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'><s:if test="%{getNombre()<getSm()&&getNombre()>getSa()}"><i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true" style="font-size: 20px; color:rgb(191, 178, 0);"></i></s:if><s:if test="%{getNombre()<getSa()&&getNombre()>getSs()}"><i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true" style="font-size: 20px; color:#FF5722;"></i></s:if><s:if test="%{getNombre()<getSs()}"><i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true" style="font-size: 20px; color:#F44336;"></i></s:if></td>
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'><s:property value="getCode()" /></td> 
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'><s:property value="getArticle()" /></td>  
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'><s:property value="getFamille()"/></td>
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'><s:property value="getEmplacement()"/></td>
                                                                            <td class="clickable-row" data-href='historiqueArticle?idArticle=<s:property value="getId()"></s:property>&article=<s:property value="getArticle()" />'  id="mt<s:property value="getId()" />" value="<s:property value="getNombre()" />" ><s:property value="getNombre()" /></td>                         
                                                                                <td>
                                                                                    <input type="hidden" id="preselected<s:property value="getId()" />" value="<s:property value="getUnite()" />">
                                                                                <select onchange='updateUnity("tr<s:property value="getId()" />", "ut<s:property value="getId()" />", "mt<s:property value="getId()" />", "preselected<s:property value="getId()" />")' id="ut<s:property value="getId()" />">
                                                                                    <option>
                                                                                        <s:property value="getUnite()" />
                                                                                    </option>
                                                                                    <s:iterator value="getUniteService().getEquivalent(getUnite())">
                                                                                        <option><s:property value="getDesignation()" /></option>
                                                                                    </s:iterator>
                                                                                </select>
                                                                            </td>
                                                                            <td style="text-align: right;" class="clickable-row" data-href='ajoutArticle?idDernierArticle=<s:property value="getId()"></s:property>'><s:property value="getValeur()" /></td>                                                                         
                                                                            </tr>
                                                                    </s:iterator>                                                                        
                                                                </tbody>
                                                            </table>                                                        
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
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
<script>
                                                                                    function updateUnity(montant, designation, destination, select) {
                                                                                        var param = document.getElementById(designation).value;
                                                                                        var rowUtile = $('#' + montant);
                                                                                        var ancienNombre = $(rowUtile).find('td').eq(5).text();
                                                                                        var valeurActuel = $('#' + select).val();//$(rowUtile).find('td').eq(6).text();
//        console.log(valeurActuel);

                                                                                        $.post("conversion",
                                                                                                {
                                                                                                    existant: ancienNombre,
                                                                                                    uniteSelectionnee: param,
                                                                                                    valeurActuel: valeurActuel,
                                                                                                    dataType: JSON
                                                                                                },
                                                                                                function (data, status) {
                                                                                                    if (data != null) {
//                console.log(data);
                                                                                                        document.getElementById(destination).innerHTML = data;
                                                                                                    } else {
                                                                                                        alert("le client est encore en appel");
                                                                                                    }
                                                                                                    $('#' + select).val(param);
//            console.log($('#'+ select).val());
                                                                                                });
                                                                                    }
</script>
</body>

</html>