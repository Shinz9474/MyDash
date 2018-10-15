<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<table class="table">
<thead>
<tr>
<th>Project Name</th>
<th>Project Description</th>
<th>isActive</th>
<th>Created By</th>
<th>Created Date</th>
<th>Modified By</th>
<th>Modified Date</th>
<th></th>
</tr>
</thead>
<tbody>
<tr ng-repeat="project in ctrl.projects">
<td><input class="form-control" type="text" ng-model="project.projectName" ng-change="changed(project,$index)"/> </td>
<td><textarea class="form-control" ng-model="project.projectDescription" ng-change="changed(project,$index)"></textarea></td>
<td>
<select class="form-control" ng-model="project.isActive" ng-change="changed(project,$index)">
  <option  ng-selected= "{{value.id == project.isActive}}" ng-repeat="value in projectActiveStatuses" 
                      value="{{value.id}}">{{value.text}}     
              </option>

</select>
</td>
<td>{{project.createdBy}}</td>
<td>{{project.createdDate}}</td>
<td>{{project.modifiedBy}}</td>
<td>{{project.modifiedDate}}</td>
<td>
       <a  href="#" ng-click="deleteProject($index,project.projectId)"> <i class="fa fa-trash" style="color:red"></i></a>
      </td>
</tr>
</tbody>
</table>