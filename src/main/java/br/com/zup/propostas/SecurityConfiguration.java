package br.com.zup.propostas;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                authorizeRequest -> authorizeRequest
                        .antMatchers("/api/biometria/**").hasAuthority("SCOPE_propostas:write")
                        .antMatchers("/api/propostas/**").hasAuthority("SCOPE_propostas:write")
                        .antMatchers("/api/solicitacao").hasAuthority("SCOPE_propostas:write")
                        .anyRequest().authenticated()
        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }
}
