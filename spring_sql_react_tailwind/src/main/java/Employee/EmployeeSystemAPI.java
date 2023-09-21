package Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"controller", "services"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
public class EmployeeSystemAPI {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeSystemAPI.class, args);
  }

}