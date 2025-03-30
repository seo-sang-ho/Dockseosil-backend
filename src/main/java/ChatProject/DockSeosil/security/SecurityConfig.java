package ChatProject.DockSeosil.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(); // 빈 등록
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (필요에 따라)
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth/**").permitAll() // 회원가입, 로그인 API는 인증 없이 허용
				.anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
			)
			.formLogin(login -> login.disable())  // 기본 로그인 폼 제거
			.httpBasic(basic -> basic.disable()); // HTTP Basic 인증 제거

		return http.build();
	}
}
