package se.webshop.restserver.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.json.auth.UserInfo;

import se.webshop.restserver.entities.Role;
import se.webshop.restserver.entities.User;
import se.webshop.restserver.repository.RoleRepository;
import se.webshop.restserver.repository.UserRepository;
import se.webshop.restserver.security.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserController(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> login(@RequestParam String accessToken) {
		Assert.notNull(accessToken, "UserController::login: accessToken can't be null.");
		Optional<UserInfo> info = AuthenticationService.verifyLogin(accessToken);
		
		if(info.isPresent()) {
			String id = info.get().getValues().get("sub").toString();
			System.out.println(id);
			if(!userRepository.findByHashId(id).isPresent()) {
				logger.debug("creating a new User with access token: "+accessToken);
				userRepository.save(createUser(id));
			}
			//Retrieve user information
			User user = userRepository.findByHashId(id).get();
			user.setBillingAddress("rödkallen");
			System.out.println(user.toString());
			logger.debug("user logged in with access token: "+accessToken);
			return ResponseEntity.ok(user);
			
		}
		logger.debug("unauthorized access token: "+accessToken);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	private User createUser(String id) {
		User user = new User();
		user.setDateJoined(LocalDateTime.now());
		user.setHashId(id);
		user.setRole(roleRepository.findByroleType(Role.RoleType.USER));
		return user;
	}
	
}
