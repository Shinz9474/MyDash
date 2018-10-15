<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value='/static/css/xeditable.css' />" rel="stylesheet"></link>
  
 
</head>
<body ng-app="myApp">

<div ng-controller="MKBotProjectController as ctrl">
  <form editable-form name="tableform" onaftersave="saveTable()" oncancel="cancel()">

<div ng-include src="isEdit ? 'tableEdit.html' : 'tableView.html'"></div>
    

    <!-- buttons -->
    <div class="btn-edit">
      <button type="button" class="btn btn-default" ng-show="!tableform.$visible" ng-click="tableform.$show()">
        edit
      </button>
    </div>
    <div class="btn-form" ng-show="tableform.$visible">
      <button type="button" ng-disabled="tableform.$waiting" ng-click="addProject()" class="btn btn-default pull-right">add row</button>
      <button type="submit" ng-disabled="tableform.$waiting" class="btn btn-primary">save</button>
      <button type="button" ng-disabled="tableform.$waiting" ng-click="tableform.$cancel()" class="btn btn-default">cancel</button>
    </div> 
    
  </form>
</div>
 
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script>

var app = angular.module("myApp", []);



</script> 
      
      <script src="<c:url value='/static/js/service/MKBotProjectService.js' />"></script>
      <script src="<c:url value='/static/js/controller/MKbotProjectControllers.js' />"></script>
      
      <script src="<c:url value='/static/js/jquery.min.js' />"></script>
       <script src="<c:url value='/static/js/xeditable.js' />"></script>

</body>
</html>