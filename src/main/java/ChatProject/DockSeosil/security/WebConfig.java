package ChatProject.DockSeosil.security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins("http://localhost:5173")
			.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
			.allowCredentials(true)
			.allowedHeaders("*");
	}
}
