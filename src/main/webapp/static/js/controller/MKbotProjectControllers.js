'use strict';

angular.module('myApp').controller('MKBotProjectController', ['$scope', '$http','ProjectService','$filter','$q', function($scope,$http, ProjectService,$filter,$q) {
	  var REST_SERVICE_URI = 'http://10.4.64.106:8080/MkBot/MkBotProject/';
	var self = this;
	self.insertProject={projectId:null,projectName:'',projectDescription:'',createdBy:'',createdDate:'',modifiedBy:'',modifiedDate:'',isActive:''};
	self.updateProject={projectId:null,projectName:'',projectDescription:'',createdBy:'',createdDate:'',modifiedBy:'',modifiedDate:'',isActive:''};
	self.deleteProject={projectId:null,projectName:'',projectDescription:'',createdBy:'',createdDate:'',modifiedBy:'',modifiedDate:'',isActive:''};
	$scope.projectActiveStatuses = [
	    {id: 1, text: 'Yes'},
	    {id: 0, text: 'No'}
	    
	  ];
	 $scope.isEdit=false; //this is a flag used to convert plain table to editable table
	$scope.deletedProjects=[];// This will have deleted projects ids
	 self.projects=[];//this will have all project details
	 $scope.insertProjects=[];//this will holds all inserted projects details
	 $scope.updateProjects=[];//This will have all updated project details


	    fetchAllProjects();

	    //This method will call GetAllProjects Api to get All projects and will display in the page
	    function fetchAllProjects(){
	    	 var deferred = $q.defer();
	         $http.get(REST_SERVICE_URI+"/GetAllProjects")
	             .then(
	             function (response) {
	            	 self.projects=response.data;
	                 deferred.resolve(response.data);
	                 
	             },
	             function(errResponse){
	                 console.error('Error while fetching Users');
	                 deferred.reject(errResponse);
	                 
	             }
	         );
	        // return deferred.promise;
	    	
//	    	ProjectService.fetchAllUsers()
//	            .then(
//	            function(d) {
//	                self.projects = d;
//	            },
//	            function(errResponse){
//	                console.error('Error while fetching Users');
//	            }
//	        );
	    }
	    
	    
    //deleteProject - This method will delete the project from projects list and sending project id to deleteProjects list
	    $scope.deleteProject = function($index,$projectId) {
	    	 self.projects.splice($index, 1);
	    	 if($projectId!=null)
	    	 $scope.deletedProjects.push($projectId);
		    };
	    //This will call when there is on change event fired and this is for update service/Api
	    $scope.changed=function($project,$index){
	    	
	    	if($project.projectId!=null){
	    		
	    		if($scope.updateProjects.length==0){
		    		
		    		$scope.updateProjects.push($project);
		    		
		    	}
		    	else{
		    		
		    		for(var i=0;i<=$scope.updateProjects.length-1;i++){
			    		if($scope.updateProjects[i].projectId==$project.projectId){
			    			$scope.updateProjects[i].projectName=$project.projectName;
			    			$scope.updateProjects[i].isActive=$project.isActive;
			    			$scope.updateProjects[i].projectDescription=$project.projectDescription;
			    			
			    		}
			    		else{
			    			$scope.updateProjects.push($project);
			    		}
			    	}
		    		
		    	}
	    		
	    	}
	    	else{
	    		for(var i=0;i<=$scope.insertProjects.length-1;i++){
		    		if($scope.insertProjects[i].index==$index){
		    			$scope.insertProjects[i].projectName=$project.projectName;
		    			if($project.isActive!="")
		    			$scope.insertProjects[i].isActive=$project.isActive;
		    			$scope.insertProjects[i].projectDescription=$project.projectDescription;
		    			
		    		}
		    		
		    	}
	    		
	    		
	    		
	    	}
	    	
	    	
	    }
	    
	    //this method will generate status of project
	    $scope.showStatus = function(project) {
	      var selected = [];
	      if(project.isActive) {
	        selected = $filter('filter')($scope.statuses, {value: project.isActive});
	      }
	      return selected.length ? selected[0].text : 'Not set';
	    };

	    $scope.AddProject=function(){
	    	self.projects.push({projectName:'',projectDescription:'',isActive:''});
	    	$scope.insertProjects.push({projectName:'',projectDescription:'',isActive:0,index:self.projects.length-1});
	    }


	    //This method will cancel all operation
	    $scope.cancel = function () {
	    	fetchAllProjects();
	        $scope.isEdit = false;
	        $scope.deletedProjects=[];
	        $scope.updateProjects=[];
	        $scope.insertProjects=[];
	      };
	    

	      //Save Project Details - This method will handle CRUD
	      $scope.SaveProject=function(){
	    	  if($scope.isEdit==true)
	    	  {
	    		  //Delete Process
	    		  for(var i=0;i<=$scope.deletedProjects.length-1;i++){
	    			  ProjectService.deleteProject($scope.deletedProjects[i]);
	    		  }  
	    		  
	    		  //Update Process
	    		  for(var i=0;i<=$scope.updateProjects.length-1;i++){
	    			  if($scope.updateProjects[i].projectId!=null){
	    				  var deferred = $q.defer();
		    			  $http.put(REST_SERVICE_URI+"UpdateProject/",$scope.updateProjects[i])				  
		    			  .then(
		    					  function (response) {
						          
		    						  fetchAllProjects();
						              
		    						  deferred.resolve(response.data);
						            },
						            function(errResponse){
						              
						            	console.error('Error while updating User');
						                deferred.reject(errResponse);
						            }				        
		    			  );  
	    			  }
	    			  
	    		  }
	    		  
	    		  //insert Process
	    		  for(var i=0;i<=$scope.insertProjects.length-1;i++){
	    			  var deferred = $q.defer();
	    			  $http.post(REST_SERVICE_URI+"CreateProject/",$scope.insertProjects[i])				  
	    			  .then(
	    					  function (response) {
					          
	    						  fetchAllProjects();
					              
	    						  deferred.resolve(response.data);
					            },
					            function(errResponse){
					              
					            	console.error('Error while updating User');
					                deferred.reject(errResponse);
					            }				        
	    			  );
	    		  }
					  
	    	  }			
	    	  $scope.isEdit =  !$scope.isEdit;
			  
	      }

}]);