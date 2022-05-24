package com.erole.moviErole.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.erole.moviErole.service.UserService;

/**
 * Clase de configuracion de seguridad web del proyecto.
 * @author pepes
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserService userService;
	
	/**
	 * Establece las direccion publicas dentro del proyecto.
	 * Establecemos la pagina de login que nosotros hemos creado.
	 * Y establecemos la configuracion del logout, como la direccion, mensaje de exito, etc.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**", "/", "/h2-console", "/resources/", "/static/**", "/css/**", "/js/**", "/img/**", "/vendor/**", "/app/about")
		.permitAll().anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/user/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout")
		.permitAll();
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
	}
	
	/**
	 * Configuracion de seguridad del proyecto.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	/**
	 * Nos crea un objeto de la clase BCryptPasswordEncoder para encriptar contraseñas.
	 * @return -> encriptar de contraseñas
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Metodo usado por el login para comprobar credenciales de usuario
	 * @return -> objeto que otorga autenticacion.
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
}
