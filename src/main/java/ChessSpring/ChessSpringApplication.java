package ChessSpring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "API for chess elements",
				version = "0.01",
				description = "board modifying elements for chess playthrough"
		)
)
@SpringBootApplication
public class ChessSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessSpringApplication.class, args);
	}

}
