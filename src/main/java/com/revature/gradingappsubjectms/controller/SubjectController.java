package com.revature.gradingappsubjectms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gradingappsubjectms.dto.Message;
import com.revature.gradingappsubjectms.exception.ServiceException;
import com.revature.gradingappsubjectms.model.Subject;
import com.revature.gradingappsubjectms.service.SubjectService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService subjectservice;
	
	@PostMapping("Subject")
    @ApiOperation(value = "Subject API")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully LogedIn", response = Subject.class),
            @ApiResponse(code = 400, message = "Invalid Access", response = Message.class) })
 public ResponseEntity<?> loginController(@RequestParam("id") int id) {
String errorMessage = null;
     String status = "";
     Optional<Subject> subject=null;
try {
	subject= subjectservice.findbyId(id);
         status = "success";
     } catch (ServiceException e) {
         errorMessage = e.getMessage();
     }
     if (status.equals("success")) {
         return new ResponseEntity<>(subject, HttpStatus.OK );
     } else{
         Message message = new Message(errorMessage);
         return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
     }
} 

	
	@GetMapping("/subjectList")
	@ApiOperation(value = "SubjectList API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Subject.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> subjectList() throws ServiceException {

		List<Subject> list = null;
		String errorMessage = null;
		list = subjectservice.subject();
		Message message = null;
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
