package za.com.ayo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication(scanBasePackages = {"za.com"})
@EnableSwagger2
public class AyoConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyoConversionApplication.class, args);
	}

	// swagger configuration.
	@Bean
	public Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().description("This Micorservice " +
				"serves" + " AyoConversion").title("AyoConversion").version("1.0").build()).select().paths(regex("/v1.*")).build();
	}


}
