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
        <link href="build/css/mine.css" rel="stylesheet">

        <script>
            (function (e, t, n) {
                var r = e.querySelectorAll("html")[0];
                r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
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
                                <h3>Bon d'entrée</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="enregistrer" method="POST" enctype="multipart/form-data">
                                        <div class="x_title">
                                            <div class="col-md-7 col-sm-7">
                                                <h2>Details</h2>
                                            </div>
                                            <div class="col-md-5 col-sm-5">
                                                <div class="col-md-8 col-md-8 col-sm-6 col-xs-6">
                                                    <div class="form-group" style="margin-bottom: -9px;">
                                                        <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                            <s:if test="%{nomPrenomDemandeur != ''}">
                                                                <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="nomPrenomDemandeur" value="<s:property value="%{nomPrenomDemandeur}"></s:property>">
                                                            </s:if>
                                                            <s:else>
                                                                <input type="text" id="first-name" class="form-control col-md-7 col-xs-12" name="nomPrenomDemandeur" placeholder="Nom et prenom du demandeur">
                                                            </s:else>
                                                            <div class="input-group-btn">
                                                                <button class="btn goArticle" type="button" style="margin-right: 0px;" data-href='listeUser?idDernierArticle=<s:property value="getIdDernierArticle()"></s:property>&type=1'>...</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4 col-md-4 col-sm-6 col-xs-6">
                                                        <input type="date" id="first-name" class="form-control" name="dateToday" style="max-width: 150px;">
                                                    </div>
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

                                                                <div class="col-md-10 col-sm-10">
                                                                    <div class="form-group" style="margin-bottom: -9px;">
                                                                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Article <span class="required">*</span></label>
                                                                        <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <s:if test="%{codeDernierArticle != ''}">
                                                                            <input type="text" onblur="updateIdArticle()" id="designationArticle" class="form-control col-md-7 col-xs-12 typeahead" name="codeDernierArticle" value="<s:property value="%{codeDernierArticle}"></s:property>">
                                                                        </s:if>
                                                                        <s:else>
                                                                            <input type="text" onblur="updateIdArticle()" id="designationArticle" class="form-control col-md-7 col-xs-12 typeahead" name="codeDernierArticle" value="<s:property value="%{codeDernierArticle}"></s:property>">
                                                                        </s:else>

                                                                        <div class="input-group-btn">
                                                                            <button class="btn goArticle" type="button" style="margin-right: 0px;" data-href='listeArticle?type=1&idDemandeur=<s:property value="%{idDemandeur}"></s:property>'>...</button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group" style="margin-bottom: -9px;">
                                                                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Fournisseur <span class="required">*</span></label>
                                                                        <div class="col-md-10 col-sm-10 col-xs-12 input-group">                                                                        
                                                                            <input type="text" id="dernierFournisseur" onblur="updateIdFournisseur()" class="form-control col-md-7 col-xs-12 typeaheadd" name="dernierFournisseur" value="<s:property value="%{dernierFournisseur}"></s:property>">
                                                                            <div class="input-group-btn" id="btnGoFournisseur">
                                                                                <button class="btn goArticle" type="button" style="margin-right: 0px;" data-href='listeFournisseur?idDernierArticle=<s:property value="%{idDernierArticle}"></s:property>&type=1'>...</button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group" style="margin-bottom: -9px;">
                                                                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Unite <span class="">*</span></label>
                                                                        <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                            <select id="listeUnite" class="form-control col-md-7 col-xs-12" name="unite">
                                                                            <s:iterator value="getListeU()">
                                                                                <s:if test="%{unite==getDesignationUnite()}">
                                                                                    <option selected value="<s:property value="getDesignation()" />"><s:property value="getDesignation()" /></option>
                                                                                </s:if>
                                                                                <s:else>
                                                                                    <option value="<s:property value="getDesignation()" />"><s:property value="getDesignation()" /></option>
                                                                                </s:else>
                                                                            </s:iterator>                                                                                                                                                                    
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Nombre <span class="">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="number" step="0.01" id="first-name" step="0.01" class="form-control col-md-7 col-xs-12" name="nombre">
                                                                    </div>
                                                                </div>                              
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Prix unitaire <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <input type="number" step="0.01" id="first-name" class="form-control col-md-7 col-xs-12" value="<s:property value="%{prixSelonFournisseur}" />" name="prixSelonFournisseur">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group" style="margin-bottom: -9px;">
                                                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" style="margin-left: 0px;width: 102px;padding-left: 0px;">Commentaire <span class="required">*</span></label>
                                                                    <div class="col-md-10 col-sm-10 col-xs-12 input-group">
                                                                        <textarea id="commentaire" class="form-control" data-parsley-trigger="keyup" data-parsley-maxlength="100"
                                                                                  data-parsley-validation-threshold="10" name="coms"></textarea>
                                                                    </div>
                                                                </div>
                                                                <s:hidden name="idDernierArticle" value="%{idDernierArticle}"></s:hidden>
                                                                <s:hidden name="idDernierFournisseur" value="%{idDernierFournisseur}"></s:hidden>
                                                                <s:hidden name="idDemandeur" value="%{idDemandeur}"></s:hidden>
                                                                </div>
                                                                <div class="col-md-2 col-sm-2 col-xs-2">
                                                                    <button type="button" class="btn btn-default form-control add">Ajouter</button>
                                                                    <div class="clearfix"></div>
                                                                    <div class="ln_solid"></div>
                                                                    <input style="margin-bottom: 5px;" class="form-control" type="text" name="facture" placeholder="N°facture">
                                                                    <input style="display:none; cursor: pointer;" type="file" name="photos" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected"
                                                                           multiple="">
                                                                    <label class="btn btn-default form-control" for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path></svg> <span>Support</span></label>

                                                                    <button class="btn btn-primary form-control" type="submit" >Enregistrer</button>
                                                                    <button class="btn btn-danger form-control goArticle" type="button" data-href="annulerEntree" >Annuler</button>
                                                                </div>

                                                            <s:if test="%{checkList!=''}">
                                                                <div class="clearfix"></div>
                                                                <div class="ln_solid"></div>
                                                                <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="table-responsive">
                                                                                <table class="table   bulk_action">
                                                                                    <thead>
                                                                                        <tr class="headings">
                                                                                            <th class="column-title">Reference</th>
                                                                                            <th class="column-title">Designation </th>
                                                                                            <th class="column-title">Famille </th>
                                                                                            <th class="column-title">Fournisseur </th>
                                                                                            <th class="column-title" style="text-align: right;">Prix unitaire </th>
                                                                                            <th class="column-title" style="text-align: right;">Unite </th>
                                                                                            <th class="column-title" style="text-align: right;">Nombre </th>
                                                                                            <th class="column-title" style="text-align: right;">Valeur </th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="listeArticle">
                                                                                            <tr>                                                                                                                                                                    
                                                                                                <td><s:property value="getCode()" /></td>
                                                                                                <td><s:property value="getDesignation()" /></td>
                                                                                                <td><s:property value="getFamille().getDesignation()" /></td>
                                                                                                <td class=" "><s:property value="getFournisseur().getNom()" /></td>
                                                                                                <td class=" " style="text-align: right;"><s:property value="getPrixUnitaire()" /></td>
                                                                                                <td class=" " style="text-align: right;"><s:property value="getUnite().getDesignation()" /></td>
                                                                                                <td class=" " style="text-align: right;"><s:property value="getNombre()" /></td>
                                                                                                <td class=" " style="text-align: right;"><s:property value="getPrixTotal()" /></td>
                                                                                            </tr>
                                                                                        </s:iterator>                                                                                        
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </s:if>



                                                        </div>

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

    <script src="vendors/typeahead/bloodhound.js"></script>
    <script src="vendors/typeahead/typeahead.bundle.min.js"></script>
    <script src="vendors/typeahead/typeahead.bundle.js"></script>
    <script src="vendors/typeahead/typeahead.jquery.js"></script>

    <script>
                                                                                jQuery(document).ready(function ($) {
                                                                                    $(".goArticle").click(function () {
                                                                                        window.location = $(this).data("href");
                                                                                    });
                                                                                    $(".add").click(function () {
                                                                                        window.location = "ajouter?codeDernierArticle=" + $('[name="codeDernierArticle"]').val() + "&dernierFournisseur=" + $('[name="dernierFournisseur"]').val() + "&unite=" + $('[name="unite"]').val() + "&nombre=" + $('[name="nombre"]').val() + "&prixSelonFournisseur=" + $('[name="prixSelonFournisseur"]').val() + "&coms=" + $('[name="coms"]').val() + "&idDernierArticle=" + $('[name="idDernierArticle"]').val() + "&idDernierFournisseur=" + $('[name="idDernierFournisseur"]').val();
                                                                                    });
                                                                                });
                                                                                (function ($) {
                                                                                    $.fn.fillValues = function (options) {
                                                                                        var settings = $.extend({
                                                                                            datas: null,
                                                                                            complete: null
                                                                                        }, options);

                                                                                        this.each(function () {
                                                                                            var datas = settings.datas;
                                                                                            if (datas != null) {
                                                                                                $(this).empty();
                                                                                                for (var key in datas) {
                                                                                                    $(this).append('<option value="' + datas[key] + '"+>' + datas[key] + '</option>');
                                                                                                }
                                                                                            }
                                                                                            if ($.isFunction(settings.complete)) {
                                                                                                settings.complete.call(this);
                                                                                            }
                                                                                        });
                                                                                    };
                                                                                }(jQuery));
                                                                                $('.typeahead').typeahead({
                                                                                    hint: true,
                                                                                    highlight: true
                                                                                },
                                                                                        {
                                                                                            source: function (query, processSync, processAsync) {
                                                                                                $.post("listeArticleAutocomplete",
                                                                                                        {
                                                                                                            debutArticle: "%" + document.getElementById("designationArticle").value + "%",
                                                                                                            dataType: JSON
                                                                                                        },
                                                                                                        function (json) {
                                                                                                            return processAsync(json);
                                                                                                        });
                                                                                            }
                                                                                        });
                                                                                function updateIdArticle() {
                                                                                    console.log(document.getElementById("designationArticle").value);
                                                                                    $.post("idArticleJson",
                                                                                            {
                                                                                                designationArticle: document.getElementById("designationArticle").value,
                                                                                                dataType: JSON
                                                                                            },
                                                                                            function (json) {
                                                                                                console.log(json[0]);
                                                                                                $('[name="idDernierArticle"]').val(json[0]);
//                        $('#btnGoFournisseur').innerHtml="<button class='btn goArticle' type='button' style='margin-right: 0px;' data-href='listeFournisseur?idDernierArticle="+json[0]+"&type=1'>...</button>";
                                                                                                document.getElementById('btnGoFournisseur').innerHTML = "<a href = 'listeFournisseur?idDernierArticle="+json[0]+"&type=1'><button class='btn goArticle' type='button' style='margin-right: 0px;' data-href='listeFournisseur?idDernierArticle="+json[0]+"&type=1'>...</button></a>";
//                                                                                                $('#btnGoFournisseur').html = "<a href='#'>test</a>";
                                                                                                console.log($('[name="idDernierArticle"]').val());
                                                                                                console.log(json[1]);
                                                                                                $("#listeUnite").fillValues({datas: json[1]});
                                                                                            });
                                                                                }
                                                                                $('.typeaheadd').typeahead({
                                                                                    hint: true,
                                                                                    highlight: true
                                                                                },
                                                                                        {
                                                                                            source: function (query, processSync, processAsync) {
                                                                                                $.post("listeFournisseurAutocomplete",
                                                                                                        {
                                                                                                            debutArticle: "%" + document.getElementById("dernierFournisseur").value + "%",
                                                                                                            idDernierArticle: $('[name="idDernierArticle"]').val(),
                                                                                                            dataType: JSON
                                                                                                        },
                                                                                                        function (json) {
                                                                                                            return processAsync(json);
                                                                                                        });
                                                                                            }
                                                                                        });
                                                                                function updateIdFournisseur() {
                                                                                    console.log(document.getElementById("designationArticle").value);
                                                                                    $.post("idFournisseurJson",
                                                                                            {
                                                                                                designationArticle: document.getElementById("dernierFournisseur").value,
                                                                                                idDernierArticle: $('[name="idDernierArticle"]').val(),
                                                                                                dataType: JSON
                                                                                            },
                                                                                            function (json) {
                                                                                                console.log(json[0]);
                                                                                                $('[name="idDernierFournisseur"]').val(json[0]);
                                                                                                console.log($('[name="idDernierFournisseur"]').val());
                                                                                                console.log(json[1]);
                                                                                                $('[name="prixSelonFournisseur"]').val(json[1]);
                                                                                            });
                                                                                }
    </script>

</body>

</html>