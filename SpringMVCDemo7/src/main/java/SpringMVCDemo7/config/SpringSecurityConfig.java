package SpringMVCDemo7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import SpringMVCDemo7.handler.LoginSucessHandler;
import SpringMVCDemo7.handler.LogoutHandler;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"SpringMVCDemo7.repository",
		"SpringMVCDemo7.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationSuccessHandler loginSuccessHandler;
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary c = new Cloudinary(ObjectUtils.asMap(
					"cloud_name" , "dskoc6e8s",
					"api_key","468395454874438",
					"api_secret","skMKfLgg1g1NsVyVAUEnU8Haeu8",
					"secure",true
				));
		
		return c;
	}
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSucessHandler();
	}
	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new LogoutHandler();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
		http.formLogin().successHandler(loginSuccessHandler);
		http.logout().logoutSuccessUrl("/login");
		http.logout().logoutSuccessHandler(logoutSuccessHandler);
		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.csrf().disable();
		
	}
}
