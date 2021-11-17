package clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dto.User;

@Component
public class UserClient {
	
	private static final String userServiceBaseUrl = "http://localhost:8080/authApi/v1";
	
	@Autowired
	RestTemplate restTemplate;

	public User getUserById(String user_id) {

		
		return null;
	}

}
