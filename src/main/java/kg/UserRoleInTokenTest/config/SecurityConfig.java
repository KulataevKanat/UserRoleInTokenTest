package kg.UserRoleInTokenTest.config;

import kg.UserRoleInTokenTest.security.JwtSecurityConfigurer;
import kg.UserRoleInTokenTest.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                //Premise
                .antMatchers("/api/premise").hasRole("ADMIN")
                .antMatchers("/api/premise/{id}").hasRole("ADMIN")
                .antMatchers("/api/premise").hasRole("ADMIN")

                //User
                .antMatchers("/api/user/{id}").hasRole("USER")
                .antMatchers("/api/user").hasRole("USER")

                //Security
                .antMatchers("/api/security/sign-in").permitAll()

                //Swagger
                .antMatchers(AUTH_WHITELIST).permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .apply(new JwtSecurityConfigurer(jwtTokenProvider));
        ;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
