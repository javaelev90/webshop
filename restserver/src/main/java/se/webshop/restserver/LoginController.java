package se.webshop.restserver;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.APIException;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.Request;

import security.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@GetMapping
	public ResponseEntity<?> login(@RequestParam String accessToken) {
		Optional<UserInfo> info = AuthenticationService.verifyLogin(accessToken);
		
		if(info.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
}
