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

import com.MKBot.POJOClasses.UpdateLocatorTypeResponse;
import com.MKBot.domain.MKBotLocatorType;
import com.MKBot.service.MKBotLocatorTypeServiceImpl;

@RestController
public class MKBotLocatorTypeRestController {

	@Autowired
	MKBotLocatorTypeServiceImpl locatorTypeService;
	UpdateLocatorTypeResponse updateLocatorTypeResponse = new UpdateLocatorTypeResponse();

	@RequestMapping(value = "/MKBotLocatorType/createLocatorType", method = RequestMethod.POST)
	public ResponseEntity<List<MKBotLocatorType>> createUser(@RequestBody MKBotLocatorType locatorType,
			UriComponentsBuilder ucBuilder) throws ParseException {
		int count = locatorTypeService.createLocatorType(locatorType);
		List<MKBotLocatorType> insertedLocatorType = locatorTypeService.getInsertedLoactorType();
		if (count > 0)
			return new ResponseEntity<List<MKBotLocatorType>>(insertedLocatorType, HttpStatus.OK);
		else
			return new ResponseEntity<List<MKBotLocatorType>>(insertedLocatorType, HttpStatus.INTERNAL_SERVER_ERROR);
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

	}

	@RequestMapping(value = "/MKBotLocatorType/getAllLocatorTypes", method = RequestMethod.GET)
	public ResponseEntity<List<MKBotLocatorType>> getAllLocatorTypes() {
		List<MKBotLocatorType> locatorType = null;
		// List<MKBotLocatorType> locatorType = locatorTypeService.getAllLocatorTypes();
		try {
			locatorType = locatorTypeService.getAllLocatorTypes();
		} catch (Exception ex) {
			return new ResponseEntity<List<MKBotLocatorType>>(locatorType, HttpStatus.SERVICE_UNAVAILABLE);
		}
		if (locatorType.isEmpty()) {
			return new ResponseEntity<List<MKBotLocatorType>>(locatorType, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MKBotLocatorType>>(locatorType, HttpStatus.OK);

	}

	@RequestMapping(value = "/MKBotLocatorType/updateLocatorType", method = RequestMethod.PUT)
    public ResponseEntity<UpdateLocatorTypeResponse> updateLocatorType(@RequestBody MKBotLocatorType locatorType,    UriComponentsBuilder ucBuilder) throws ParseException {
		
	 int count=locatorTypeService.updateLocatorType(locatorType);
	 if(count>0)
	 {
		 updateLocatorTypeResponse.setProcessingMessage("Successfully updated the locator type");
		 return new ResponseEntity<UpdateLocatorTypeResponse>(updateLocatorTypeResponse, HttpStatus.OK);
	 }
	 else
	 {
		 updateLocatorTypeResponse.setProcessingMessage("Locator type update failed");
		 return new ResponseEntity<UpdateLocatorTypeResponse>(updateLocatorTypeResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
		/* return new ResponseEntity<String>("LocatorType updated", HttpStatus.OK);
	 else
		 return new ResponseEntity<String>("Unable to update LocatorType. Please check the details", HttpStatus.SERVICE_UNAVAILABLE);*/
	}

	@RequestMapping(value = "/MKBotLocatorType/deleteLocatorType", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLocatorType(@RequestBody MKBotLocatorType locatorType,
			UriComponentsBuilder ucBuilder) throws ParseException {
		int count = locatorTypeService.deleteLocatorType(locatorType);
		if (count > 0)
			return new ResponseEntity<String>("LocatorType updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Unable to update LocatorType. Please check the details",
					HttpStatus.SERVICE_UNAVAILABLE);
	}
}
