package com.MKBot.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MKBot.domain.MKBotUser;
import com.MKBot.domain.MKBotUserRestDomain;
import com.MKBot.service.MKBotUserServiceImpl;

@RestController
public class MkBotUserRestController {
	
	@Autowired
	MKBotUserServiceImpl userService;
	
	 @RequestMapping(value = "/MkBotUser/GetAllUsers", method = RequestMethod.GET)
	    public ResponseEntity<List<MKBotUser>> listAllUsers() {
	        List<MKBotUser> users = userService.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<MKBotUser>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<MKBotUser>>(users, HttpStatus.OK);
	    }
	 @RequestMapping(value = "/MkBotUser/CreateUser", method = RequestMethod.POST)
	    public ResponseEntity<MKBotUserRestDomain> createUser(@RequestBody MKBotUser user,    UriComponentsBuilder ucBuilder) {
		 MKBotUserRestDomain userDomain=userService.insertMkBotUser(user);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

	        return new ResponseEntity<MKBotUserRestDomain>(userDomain, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/MkBotUser/UpdateUser", method = RequestMethod.PUT)
	    public ResponseEntity<Void> updateUser(@RequestBody MKBotUser user,    UriComponentsBuilder ucBuilder) {
	        userService.updateMkBotUser(user);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.OK);
	    }
	 @RequestMapping(value = "/MkBotUser/DeleteUser", method = RequestMethod.DELETE)
	   public ResponseEntity<String> DeleteUser(@RequestParam("userName") String userName,    UriComponentsBuilder ucBuilder) {
		 if(userService.deleteMkBotUser(userName)>0)
		 return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		 else
			 return new ResponseEntity<String>("No Such User", HttpStatus.NOT_FOUND);
		 
	 }
	 

}
