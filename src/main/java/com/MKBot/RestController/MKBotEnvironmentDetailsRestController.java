package com.MKBot.RestController;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MKBot.domain.MKBotEnvironmentDetails;
import com.MKBot.service.MKBotEnvironmentDetailServiceImpl;

@RestController
public class MKBotEnvironmentDetailsRestController {
	@Autowired
	MKBotEnvironmentDetailServiceImpl environmentService;
	
	@RequestMapping(value = "/MkBotEnvironment/CreateEnvironment", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody MKBotEnvironmentDetails environment,    UriComponentsBuilder ucBuilder) throws ParseException {
	 int count=environmentService.CreateEnvironment(environment);
	 if(count>0)
		 return new ResponseEntity<String>("Environment Created", HttpStatus.OK);
	 else
		 return new ResponseEntity<String>("Unable to create environment. Please check the details", HttpStatus.OK);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

        
    }
	
	@RequestMapping(value = "/MkBotEnvironment/GetAllEnvironments", method = RequestMethod.GET)
    public ResponseEntity<List<MKBotEnvironmentDetails>> listAllUsers() {
        List<MKBotEnvironmentDetails> environments = environmentService.GetAllEnvironments();
        if(environments.isEmpty()){
            return new ResponseEntity<List<MKBotEnvironmentDetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MKBotEnvironmentDetails>>(environments, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/MkBotEnvironment/updateEnvironment", method = RequestMethod.POST)
    public ResponseEntity<String> updateenvironment(@RequestBody MKBotEnvironmentDetails environment,    UriComponentsBuilder ucBuilder) throws ParseException {
	 int count=environmentService.updateEnvironment(environment);
	 if(count>0)
		 return new ResponseEntity<String>("Environment updated", HttpStatus.OK);
	 else
		 return new ResponseEntity<String>("Unable to update environment. Please check the details", HttpStatus.OK);
	}
 
	@RequestMapping(value = "/MkBotEnvironment/deleteEnvironment", method = RequestMethod.POST)
    public ResponseEntity<String> createUser1(@RequestBody MKBotEnvironmentDetails environment,    UriComponentsBuilder ucBuilder) throws ParseException {
	 int count=environmentService.deleteEnvironment(environment);
	 if(count>0)
		 return new ResponseEntity<String>("Environment deleted", HttpStatus.OK);
	 else
		 return new ResponseEntity<String>("Unable to delete environment. Please check the details", HttpStatus.OK);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

        
    }

}
