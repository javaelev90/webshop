package se.webshop.restserver.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.APIException;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.Request;



public class AuthenticationService {
	//Only the first argument is needed for accessToken authentication i.e. using userInfo(String accessToken),
	//the second and third just can't be null
	private static AuthAPI auth = new AuthAPI("webshopper.eu.auth0.com", "", "");
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	private AuthenticationService() {}
	
	/**
	 * Is used to verify that the user is logged in by trying to use the
	 * access token when contacting the external OAuth2 API. If the user is logged in 
	 * a UserInfo object will be returned containing the user id, otherwise an error will be thrown.
	 * @param accessToken and access token that was retrieved from the external API
	 * @return an Optional containing a UserInfo object or an Optional.empty()
	 */
	public static Optional<UserInfo> verifyLogin(String accessToken) {
		Assert.notNull(accessToken, "AuthenticationService::verifyLogin: Access token can't be null.");
		
		Request<UserInfo> request = auth.userInfo(accessToken);
		
		try {
			UserInfo info = request.execute();
			logger.debug("verified access token "+accessToken);
			return Optional.of(info);
		    
		} catch (APIException exception) {
			logger.debug("when using access token: ( "+accessToken+" ), an exception was thrown: "+exception.getMessage());
		} catch (Auth0Exception exception) {
			logger.debug("when using access token: ( "+accessToken+" ), an exception was thrown: "+exception.getMessage());
		}
		return Optional.empty();
	}
	
}
