<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>E.Randrianarisoa</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <!--            <div class="profile_pic">
                            <img src="vue/images/img.jpg" alt="..." class="img-circle profile_img">
                        </div>-->
            <div class="profile_info">
                <span><s:property value="getUser().getPrenom()"/></span>
                <h2><s:property value="getUser().getNom()"/></h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a href="etatInventaire"><i class="fa fa-list-alt" aria-hidden="true"></i> Stock </a></li>
                    <li><a href="entree"><i class="fa fa-sign-in" aria-hidden="true"></i> Entrée </a></li>
                    <li><a href="loadSortie"><i class="fa fa-sign-out" aria-hidden="true"></i> Sortie </a></li>
                    <li><a href="historiqueProjet"><i class="fa fa-history" aria-hidden="true"></i> Historiques </a></li>
                </ul>
            </div>
            <div class="menu_section">
                <h3>Modification</h3>
                <ul class="nav side-menu">
                    <!--<li><a href="newArticle"><i class="fa fa-ticket" aria-hidden="true"></i> Articles </a></li>-->
                    <li><a><i class="fa fa-ticket" aria-hidden="true"></i> Articles <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="newArticle">Ajouter un nouveau</a></li>
                            <li><a href="listeArticle">liste</a></li>                            
                        </ul>
                    </li>
                    <li><a href="etatFournisseur"><i class="fa fa-shopping-bag" aria-hidden="true"></i> Fournisseurs </a></li>
                    <li><a href="etatUnite"><i class="fa fa-gg-circle" aria-hidden="true"></i> Unités </a></li>
                    <li><a href="etatFamille"><i class="fa fa-object-group" aria-hidden="true"></i> Familles </a></li>
                </ul>
            </div>
            <div class="menu_section">
                <h3>Personnels</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-user"></i> Utilisateurs <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="loadUser">Ajouter un nouveau</a></li>
                            <li><a href="listeUser">liste</a></li>                            
                        </ul>
                    </li>
                    <!--<li><a href="loadUser"><i class="fa fa-ticket" aria-hidden="true"></i> Utilisateurs </a></li>-->
                    <li><a href="loadDepartement"><i class="fa fa-building-o" aria-hidden="true"></i> Départements </a></li>                    
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">            
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="images/img.jpg" alt=""><s:property value="getUser().getNom()"/>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="loadUser?id=<s:property value="getUser().getId()"/>&mine=1"> Profile</a></li>
                        <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true" style="font-size: 20px; color:rgb(191, 178, 0);"></i>
                        <s:if test="getAlertes().isEmpty()">
                            <span class="badge bg-red"></span>
                        </s:if>
                        <s:else>
                            <span class="badge bg-red"><s:property value="getAlertes().size()"></s:property></span>
                        </s:else>
                    </a>
                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu" style="max-height: 400px; overflow-y: scroll;">
                        <s:set var="rowPrinted" value="0"/>                        
                        <s:iterator value="alertes">                                
                            <li>
                                <a href="ajoutArticle?idDernierArticle=<s:property value=" getArticle().getId() "></s:property>">
                                        <span class="image"><i class="fa fa-exclamation-triangle fa-5x" aria-hidden="true" style="font-size: 20px; color:rgb(191, 178, 0);"></i></span>
                                        <span>
                                            <span><s:property value="getArticle().getDesignation()"/></span>
                                        <span class="time">En dessous de la limite</span>
                                    </span>
                                    <span class="message">
                                        Veuiller réaprovisionner le stock
                                    </span>
                                </a>
                            </li>
                            <s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>                                
                        </s:iterator>                                                                            
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->