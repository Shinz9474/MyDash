<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>Project Name</th>
<th>Project Description</th>
<th>isActive</th>
<th>Created By</th>
<th>Created Date</th>
<th>Modified By</th>
<th>Modified Date</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="project in ctrl.projects">
<td>{{project.projectName}}</td>
<td>{{project.projectDescription}}</td>
<td>
<select disabled class="form-control" ng-model="project.isActive">
  <option  ng-selected= "{{value.id == project.isActive}}" ng-repeat="value in projectActiveStatuses" 
                      value="{{value.id}}">{{value.text}}     
              </option>

</select>
</td>
<td>{{project.createdBy}}</td>
<td>{{project.createdDate}}</td>
<td>{{project.modifiedBy}}</td>
<td>{{project.modifiedDate}}</td>
</tr>
</tbody>
</table>