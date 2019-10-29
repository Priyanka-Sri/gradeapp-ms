package com.revature.gradingappsubjectms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
