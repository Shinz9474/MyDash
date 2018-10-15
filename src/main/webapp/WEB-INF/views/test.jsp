<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/xeditable.css' />" rel="stylesheet"></link>
     <link href="<c:url value='/static/css/select2.min.css' />" rel="stylesheet" />

  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="MKBotProjectController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Project Name</th>
                              <th>Description</th>
                              <th>CreatedBy</th>
                              <th>Created Date</th>
                              <th>ModifiedBy</th>
                              <th>ModifedDate</th>
                              <th>IsActive</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.projects">
                              <td><span ng-bind="u.projectId"></span></td>
                              <td><a href="#" editable-text="u.projectName" ng-bind="u.projectName"></a></td>
                              <td><span ng-bind="u.projectDescription"></span></td>
                              <td><span ng-bind="u.createdBy"></span></td>
                              <td><span ng-bind="u.createdDate"></span></td>
                              <td><span ng-bind="u.modifiedBy"></span></td>
                              <td><span ng-bind="u.modifiedDate"></span></td>
                              <td><span ng-bind="u.isActive"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.projectId)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.projectId)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
                  <select  ng-model="selectedCar">
<option ng-repeat="u in ctrl.projects" value="{{u.projectId}}">{{u.projectName}}</option>
</select>
              </div>
              <select class="js-example-basic-single" name="state">
  <option value="AL">Alabama</option>
    
  <option value="WY">Wyoming</option>
</select>
          </div>
      </div>
      
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/MKBotProjectService.js' />"></script>
      <script src="<c:url value='/static/js/controller/MKbotProjectControllers.js' />"></script>
      
      <script src="<c:url value='/static/js/jquery.min.js' />"></script>
       <script src="<c:url value='/static/js/xeditable.js' />"></script>
      <script>
      $(document).ready(function() {
    	    $('.js-example-basic-single').select2();
    	 // alert("K");
    	});
      </script>
  </body>
</html>