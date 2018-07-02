package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins="https://localhost:4200")
public class LoginController {
	
	
	@PostMapping
	public ResponseEntity<?> login(String login){
		
		
		
		return null;
	}
	
}
