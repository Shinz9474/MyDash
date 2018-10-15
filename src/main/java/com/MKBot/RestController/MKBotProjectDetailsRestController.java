package com.MKBot.RestController;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MKBot.domain.MKBotEnvironmentDetails;
import com.MKBot.domain.MKBotProjectCRUD;
import com.MKBot.domain.MKBotProjectDetails;
import com.MKBot.domain.MKBotUser;
import com.MKBot.service.MKBotProjectCRUDServiceImpl;
import com.MKBot.service.MKBotProjectDetailServiceImpl;
import com.MKBot.util.MKBotDateUtil;

@RestController
public class MKBotProjectDetailsRestController {
	@Autowired
	MKBotProjectDetailServiceImpl projectService;
	
	@Autowired
	MKBotProjectCRUDServiceImpl projectCrudService;
	
	@RequestMapping(value = "/MkBotProject/CreateProject", method = RequestMethod.POST)
    public ResponseEntity<Void> createProject(@RequestBody MKBotProjectDetails project,    UriComponentsBuilder ucBuilder,HttpSession session) throws ParseException {
		MKBotUser user= (MKBotUser) session.getAttribute("user");
		project.setModifiedBy(user.getUserName());
		project.setCreatedBy(user.getUserName());
	 int count=projectService.CreateProject(project);
	 if(count>0)
		 return new ResponseEntity<Void>( HttpStatus.OK);
	 else
		 return new ResponseEntity<Void>( HttpStatus.OK);
    }
	
	@RequestMapping(value = "/MkBotProject/GetAllProjects", method = RequestMethod.GET)
    public ResponseEntity<List<MKBotProjectDetails>> listAllUsers() {
        List<MKBotProjectDetails> projects = projectService.GetAllProjects();
        if(projects.isEmpty()){
            return new ResponseEntity<List<MKBotProjectDetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MKBotProjectDetails>>(projects, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/MkBotProject/SaveProject", method = RequestMethod.POST)
	public ResponseEntity<Void> Save(@RequestBody MKBotProjectDetails projectCrud,UriComponentsBuilder ucBuilder,HttpSession session){
		
		System.out.println("Test");
		//projectCrudService.saveProject(projectCrud);
		
		return null;
		
	}
 
	@RequestMapping(value = "/MkBotProject/DeleteProject/{projectId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> DeleteProject(@PathVariable("projectId") int projectId) {
        projectService.deleteProject(projectId);
       
        return new ResponseEntity<Void>( HttpStatus.OK);
    }
	
	@RequestMapping(value = "/MkBotProject/UpdateProject/", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProject(@RequestBody MKBotProjectDetails project,HttpSession session) throws ParseException {
		
		String userName=session.getAttribute("userName").toString();
		MKBotUser user= (MKBotUser) session.getAttribute("user");
		project.setModifiedBy(user.getUserName());
		project.setModifiedDate(MKBotDateUtil.getCurrentDate().toString());
        projectService.updateProject(project);
        return new ResponseEntity<Void>( HttpStatus.OK);
    }
	

}
