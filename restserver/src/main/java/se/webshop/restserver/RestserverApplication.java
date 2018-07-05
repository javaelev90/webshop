package se.webshop.restserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestserverApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestserverApplication.class);
	public static void main(String[] args) {
		logger.debug("-- ReserserverApplication was started --");
		SpringApplication.run(RestserverApplication.class, args);
	}
}
