package com.banturov.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity //участвует в настроqке spring security
@EnableMethodSecurity
@PropertySource("classpath:application.properties")
public class securityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
		UserDetails kola = User.builder().username("kola").password(encoder.encode("password")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, kola);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth->auth.requestMatchers("/faq").permitAll()
						.requestMatchers("/**").authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll()) //.formLogin(form -> form.loginPage("login").permitAll())
				.build();
	}
	
}
