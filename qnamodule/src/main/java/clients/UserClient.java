package clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
	
	private static final String userServiceBaseUrl = "http://localhost:8080/authApi/v1";
	
	@Autowired
	RestTemplate restTemplate;


}
