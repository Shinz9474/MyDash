'use strict';

angular.module('myApp').controller('ProjectController', ['$scope', 'ProjectService', function($scope, ProjectService) {
    var self = this;
    self.project={projectId:null,projectName:'',projectDescription:'',createdBy:'',createdDate:'',modifiedBy:'',modifiedDate:'',isActive:''};
    self.projects=[];
    


    fetchAllUsers();

    function fetchAllUsers(){
        ProjectService.fetchAllUsers()
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