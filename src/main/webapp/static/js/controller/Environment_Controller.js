'use strict';

angular.module('myApp').controller('EnvironmentController', ['$scope', 'EnvironmentService', function($scope, EnvironmentService) {
    var self = this;
    self.project={environmentId:null,environmentName:'',environmentDescription:'',createdBy:'',createdDate:'',modifiedBy:'',modifiedDate:'',isActive:''};
    self.projects=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllUsers();

    function fetchAllUsers(){
        EnvironmentService.fetchAllUsers()
            .then(
            function(d) {
                self.projects = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    function createUser(user){
        
    }

    function updateUser(user, id){
        
    }

    function deleteUser(id){
       
    }

    function submit() {
       
    }

    function edit(id){
       
    }

    function remove(id){
        
    }


    function reset(){
       
    }

   

}]);