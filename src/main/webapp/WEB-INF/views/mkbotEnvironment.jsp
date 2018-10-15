<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="<c:url value='/static/images/MK circle logo.png'/> " type="image/ico" />

    <title>Bot! | Project </title>
<!-- niranjan -->
<!-- jQuery custom content scroller -->
    <link href="<c:url value='/static/css/jquery.mCustomScrollbar.min.css'/>" rel="stylesheet"/>
    <!-- Bootstrap -->
    <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet">
    
    <!-- Font Awesome -->
    <link href="<c:url value='/static/css/font-awesome.min.css'/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value='/static/css/nprogress.css'/> " rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value='/static/css/green.css'/> " rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="<c:url value='/static/css/bootstrap-progressbar-3.3.4.min.css'/>" rel="stylesheet">
    <!-- JQVMap -->
    <link href="<c:url value='/static/css/jqvmap.min.css'/>" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="<c:url value='/static/css/daterangepicker.css'/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value='/static/css/custom.min.css'/>" rel="stylesheet">

  </head>

  <body class="nav-sm" ng-controller="MKBotProjectController as ctrl">
  
    <div class="container body">
      <div class="main_container">
      
        <jsp:include page="include/DashboardMenu.jsp"></jsp:include>
        <!-- top navigation -->
        <jsp:include page="include/Top.jsp"></jsp:include>

        <!-- /top navigation -->
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>MkBot Projects Admin</h3>
              </div>

             
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>MKBot Projects</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content" >
                     <form onaftersave="saveTable()">
    					<div ng-include src="isEdit ? 'ProjectDetailsTableEdit.html' : 'ProjectDetailsTableView.html'"></div>
    					<button type="button" class="btn ng-binding btn-default" ng-show="isEdit" ng-click="AddProject()">Add</button>
    					<button type="submit" class="btn"  ng-class="{true:'btn-primary',false:'btn-default'}[isEdit]" ng-click="SaveProject()">{{ isEdit ? 'Save' : 'Edit' }}</button>
    					<button type="button" class="btn btn-danger" ng-show="isEdit" ng-click="cancel()">Cancel</button>
    					
    				</form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
        <!-- footer content -->
        <footer>
          <div class="pull-right">
           By CSS CORP Team 
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->

    <script src="<c:url value='/static/js/jquery.min.js' />"></script>
   
    <!-- Bootstrap -->
     <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    
    <!-- FastClick -->
     <script src="<c:url value='/static/js/fastclick.js' />"></script>
    
    <!-- NProgress -->
     <script src="<c:url value='/static/js/nprogress.js' />"></script>
    
    <!-- Chart.js -->
    <script src="<c:url value='/static/js/Chart.js' />"></script>
    
    <!-- gauge.js -->
    <script src="<c:url value='/static/js/gauge.min.js' />"></script>
    <!-- bootstrap-progressbar -->
    <script src="<c:url value='/static/js/bootstrap-progressbar.min.js' />"></script>
    <!-- iCheck -->
    <script src="<c:url value='/static/js/icheck.min.js' />"></script>
    <!-- Skycons -->
    <script src="<c:url value='/static/js/skycons.js' />"></script>
    <!-- Flot -->
    <script src="<c:url value='/static/js/jquery.flot.js' />"></script>
    <script src="<c:url value='/static/js/jquery.flot.pie.js' />"></script>
    <script src="<c:url value='/static/js/jquery.flot.time.js' />"></script>
    <script src="<c:url value='/static/js/jquery.flot.stack.js' />"></script>
    <script src="<c:url value='/static/js/jquery.flot.resize.js' />"></script>
    <!-- Flot plugins -->
    <script src="<c:url value='/static/js/jquery.flot.orderBars.js' />"></script>
    <script src="<c:url value='/static/js/jquery.flot.spline.min.js' />"></script>
    <script src="<c:url value='/static/js/curvedLines.js' />"></script>
    <!-- DateJS -->
    <script src="<c:url value='/static/js/date.js' />"></script>
    <!-- JQVMap -->
    <script src="<c:url value='/static/js/jquery.vmap.js' />"></script>
    <script src="<c:url value='/static/js/jquery.vmap.world.js' />"></script>
    <script src="<c:url value='/static/js/jquery.vmap.sampledata.js' />"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="<c:url value='/static/js/moment.min.js' />"></script>
    <script src="<c:url value='/static/js/daterangepicker.js' />"></script>

    <!-- Custom Theme Scripts -->
    <script src="<c:url value='/static/js/custom.min.js' />"></script>
    <!-- jQuery custom content scroller -->
    <script src="<c:url value='/static/js/jquery.mCustomScrollbar.concat.min.js'/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
       <script src="<c:url value='/static/js/app.js' />"></script>
       <script src="<c:url value='/static/js/controller/MKbotProjectControllers.js' />"></script>
      <script src="<c:url value='/static/js/service/Project_Service.js' />"></script>
      
	
  </body>
</html>