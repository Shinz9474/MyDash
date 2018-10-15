<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
 <link data-require="bootstrap-css" data-semver="3.0.2" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" />
    <style>
    body {
  margin: 15px;
  margin-top: 70px;
}
button.close {
  position: relative;
  left: -20px;
  top: 3px;
  color: red;
}
.close:hover, .close:focus {
  color: red;
}
.close {
  float: none;
}
.table-responsive {
  table-layout: fixed;
  overflow: auto;
  max-height: 200px;
}
.nowrap {
  white-space: nowrap;
}
    </style>
    
   
  </head>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
   <script src="<c:url value='/static/js/AngularApps/test.js' />"></script>
  <body ng-controller="MainCtrl">
  <form>
    <div ng-include src="isEdit ? 'tableEdit.html' : 'tableView.html'"></div>
    <button type="button" class="btn" ng-class="{true:'btn-primary',false:'btn-default'}[isEdit]" ng-click="isEdit = !isEdit">{{ isEdit ? 'Save' : 'Edit' }}</button>
    <button type="button" class="btn btn-danger" ng-show="isEdit" ng-click="cancel()">Cancel</button>
    </form>
   
  </body>
  
</html>