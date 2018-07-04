package security;

import java.util.Optional;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.APIException;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.Request;

public class AuthenticationService {
	private static AuthAPI auth = new AuthAPI("webshopper.eu.auth0.com", "86zBfl5cqraTPVbT2BSFEChzNpJ8ZX5f", "");
	
	private AuthenticationService() {}
	
	public static Optional<UserInfo> verifyLogin(String accessToken) {
		System.out.println(accessToken);
		Request<UserInfo> request = auth.userInfo(accessToken);
		
		try {
			UserInfo info = request.execute();
			System.out.println(info.getValues().toString());
			return Optional.of(info);
		    
		} catch (APIException exception) {
			System.out.println(exception);
		} catch (Auth0Exception exception) {
			System.out.println(exception);
		}
		return Optional.empty();
	}
}
