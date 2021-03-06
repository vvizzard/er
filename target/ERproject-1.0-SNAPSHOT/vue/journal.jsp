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
                                <h3>Historique</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Liste bons</h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br />
                                        <form method="get" action="rechercherListeBon">
                                            <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">   
                                                <div class="row" style="margin-bottom: 5px;">
                                                    <div class="col-md-1">
                                                        <input style="width: 100%;" type="text" placeholder="Id" name="valueId">
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input style="width: 100%;" type="text" placeholder="Demandeur" name="valueDemandeur">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input style="width: 70%; margin-left: 50px;" type="date" name="valueDate">
                                                    </div>
                                                    <div class="col-md-5">
                                                        <input style="width: 30%; margin-left: 50px;" type="submit" value="Rechercher">
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
                                                                        <th class="column-title">Id </th>
                                                                        <th class="column-title">Demandeur</th>                                                                    
                                                                        <th class="column-title">Date</th>
                                                                        <th class="column-title">Justification</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <s:iterator value="listeBon">
                                                                        <tr class="odd pointer clickable-row" data-href='historiqueArticleBon?idBon=<s:property value="getId()"></s:property>'>                                                                        
                                                                            <td><s:property value="getId()" /></td>
                                                                            <td><s:property value="getUser().getNom()" /> <s:property value="getUser().getPrenom()" /></td>                                                                                                                                                 
                                                                            <td><s:property value="getDateString()"/></td>                                                                                                                                                                                            
                                                                            <td><a href="<s:property value="getPhoto()" />"><s:property value="getPhoto()" /></a></td>                                                                         
                                                                        </tr>
                                                                    </s:iterator>                                                                        
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
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