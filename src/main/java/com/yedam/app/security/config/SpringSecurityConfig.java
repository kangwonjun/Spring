package com.yedam.app.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean // 비밀번호 암호화
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean // 메모리상 인증정보 등록 => 테스트 전용
	InMemoryUserDetailsManager inMemoryUserDetailsService() {
		UserDetails user = User.bulder().username("user1").password(passwordEncoder().encode("1234")).roles("USER") // ROLE_USER
				// .authorities("ROLE_USER")
				.build();

		return new InMemoryUserDetailsManager(user);

	}
}
