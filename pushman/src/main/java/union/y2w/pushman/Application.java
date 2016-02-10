package union.y2w.pushman;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder()
			.bannerMode(Banner.Mode.OFF)
			.sources(Application.class)
			.run(args);
	}
	
}
