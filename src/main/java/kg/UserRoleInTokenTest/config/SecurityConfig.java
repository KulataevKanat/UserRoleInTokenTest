package kg.UserRoleInTokenTest.config;

import kg.UserRoleInTokenTest.security.JwtAuthenticationEntryPoint;
import kg.UserRoleInTokenTest.security.JwtSecurityConfigurer;
import kg.UserRoleInTokenTest.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()

                .httpBasic()
                .disable()

                .cors()

                .and()

                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                //Security
                .antMatchers(HttpMethod.POST, "/api/security/sign-in").permitAll()

                //Premise
                .antMatchers(HttpMethod.POST,"/api/premise").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/api/premise/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/api/premise").hasAuthority("ROLE_ADMIN")

                //User
                .antMatchers(HttpMethod.GET,"/api/user/{id}").hasAuthority("ROLE_USER")
                .antMatchers(HttpMethod.GET,"/api/user").permitAll()

                //Swagger
                .antMatchers(AUTH_WHITELIST).permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .apply(new JwtSecurityConfigurer(jwtTokenProvider));

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
