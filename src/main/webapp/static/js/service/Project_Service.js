'use strict';

angular.module('myApp').factory('ProjectService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://10.4.64.106:8080/MkBot/MkBotProject/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser:updateUser,
        deleteUser:deleteUser,
        deleteProject:deleteProject,
        updateProjectDetails:updateProjectDetails
    };

    return factory;

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"/GetAllProjects")
            .then(
            function (response) {
                deferred.resolve(response.data);
                
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
                
            }
        );
        return deferred.promise;
    }
    function deleteProject(projectId){
    	var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+"/DeleteProject/"+projectId)
            .then(
            function (response) {
            	 
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    	
    }
    function updateProjectDetails(project){
    	var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+"UpdateProject/",project)
            .then(
            function (response) {
            	 
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    	
    }
    
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
