<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="table-responsive"><table class="table table-condensed table-striped">
  <thead>
    <tr>
      <th ng-repeat="col in table.columns">{{ col.value }}</th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="r in table.rows">
      <td ng-repeat="cell in r.cells">{{ cell.value }}</td>
    </tr>
  </tbody>
</table></div>