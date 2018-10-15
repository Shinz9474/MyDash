<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="table-responsive"><table class="table table-condensed table-striped">
  <thead>
    <tr>
      <th><span class="nowrap">
        <button type="button" class="btn btn-xs btn-success" ng-click="addCol()">add col</button>
        <button type="button" class="btn btn-xs btn-success" ng-click="addRow()">add row</button>
      </span></th>
      <th ng-repeat="col in table.columns">
        <span class="nowrap"><input type="text" ng-model="col.value" />
        <button type="button" class="close" ng-click="removeCol($index)">&times;</button></span>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="r in table.rows">
      <td>
        <button type="button" class="btn btn-xs btn-danger" ng-click="removeRow($index)">remove row</button>
      </td>
      <td ng-repeat="cell in r.cells">
        <input type="text" ng-model="cell.value" />
      </td>
    </tr>
  </tbody>
</table></div>