package se.webshop.restserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

public class SecurityConfig extends WebSecurityEnablerConfiguration{
	@Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtWebSecurityConfigurer
//                .forRS256(apiAudience, issuer)
//                .configure(http);
//    }
}
