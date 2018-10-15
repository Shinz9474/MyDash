angular.module('myApp').controller('MainCtrl', function($scope) {
  $scope.isEdit = false;

  $scope.table = buildTable();
  
  $scope.cancel = function () {
    $scope.table = buildTable();
    $scope.isEdit = false;
  };

  $scope.removeCol = function($index) {
    if ($index > -1 && $scope.table.columns.length > 1) {
      $scope.table.columns.splice($index, 1);
      for (var i = 0, len = $scope.table.rows.length; i < len; i++) {
        $scope.table.rows[i].cells.splice($index, 1);
      }
    }
  };

  $scope.removeRow = function($index) {
    if ($index > -1 && $scope.table.rows.length > 1) {
      $scope.table.rows.splice($index, 1);
    }
  };
  
  $scope.addCol = function (){
    var len = $scope.table.columns.length,
        rowLen = $scope.table.rows.length;
    $scope.table.columns.push({ value: 'Col ' + len });
    for (var i = 0; i < rowLen; i++){
      $scope.table.rows[i].cells.push({ value: 'Call ' + i + ',' + len });
    }
  };
  
  $scope.addRow = function (){
    var row = { cells: [] },
        rowLen = $scope.table.rows.length,
        colLen = $scope.table.columns.length;
        
    for (var i = 0; i < colLen; i ++) {
      row.cells.push({ value: 'Cell ' + rowLen + ',' + i });
    }
    $scope.table.rows.push(row);
  };

  function buildTable() {
    return {
      columns: [{
        value: 'Col 0'
      }, {
        value: 'Col 1'
      }, {
        value: 'Col 2'
      }],
      rows: [{
        cells: [{
          value: 'Cell 0,0'
        }, {
          value: 'Cell 0,1'
        }, {
          value: 'Cell 0,2'
        }]
      }, {
        cells: [{
          value: 'Cell 1,0'
        }, {
          value: 'Cell 1,1'
        }, {
          value: 'Cell 1,2'
        }]
      }, {
        cells: [{
          value: 'Cell 2,0'
        }, {
          value: 'Cell 2,1'
        }, {
          value: 'Cell 2,2'
        }]
      }]
    };
  }
});