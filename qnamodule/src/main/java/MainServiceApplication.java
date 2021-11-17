import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("models")
@EnableJpaRepositories("dao")
@ComponentScan("{clients,controllers,dao,services,models,dto}")
public class MainServiceApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(MainServiceApplication.class, args);
	}

}
