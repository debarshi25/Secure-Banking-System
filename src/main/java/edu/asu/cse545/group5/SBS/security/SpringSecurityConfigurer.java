/**
 * The following tutorial was referenced while implementing this authentication procedure:
 * 
 * K. Kothagal. “Spring Boot + Spring Security + JWT from scratch - Java Brains.” YouTube. https://www.youtube.com/watch?v=X80nJ5T7YpE (accessed Mar 26, 2021).
 */

package edu.asu.cse545.group5.SBS.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import edu.asu.cse545.group5.SBS.filter.JWTRequestFilter;
import edu.asu.cse545.group5.SBS.service.SBSUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired 
    private SBSUserDetailsService sBSUserDetailsService;

    @Autowired
    private JWTRequestFilter jwtFilter;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {      
       auth.userDetailsService(sBSUserDetailsService).passwordEncoder(encoder);
    }
    
    @Override 
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors();
        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/authenticate")
        .permitAll().anyRequest().authenticated().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    } 

    @Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		corsConfig.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
			"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
			"Access-Control-Request-Headers"));
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

    @Override 
    @Bean 
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
