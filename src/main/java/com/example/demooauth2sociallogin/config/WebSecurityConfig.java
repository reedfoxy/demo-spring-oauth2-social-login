package com.example.demooauth2sociallogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        List<ClientRegistration> registrations = new ArrayList<>();
        ClientRegistration facebook = CommonOAuth2Provider.FACEBOOK.getBuilder("facebook")
                .clientId(AppProperties.FACEBOOK_CLIENT_ID)
                .clientSecret(AppProperties.FACEBOOK_CLIENT_SECRET)
                .build();
        registrations.add(facebook);

        ClientRegistration google = CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId(AppProperties.GOOGLE_CLIENT_ID)
                .clientSecret(AppProperties.GOOGLE_CLIENT_SECRET)
                .scope("openid", "profile", "email","https://www.googleapis.com/auth/user.birthday.read",
                        "https://www.googleapis.com/auth/user.emails.read",
                        "https://www.googleapis.com/auth/user.addresses.read",
                        "https://www.googleapis.com/auth/user.phonenumbers.read")
                .build();
        registrations.add(google);

        ClientRegistration kakao = CustomOauth2Provider.KAKAO.getBuilder("kakao")
                .clientId(AppProperties.KAKAO_CLIENT_ID)
                .clientSecret(AppProperties.KAKAO_CLIENT_SECRET)
                .build();
        registrations.add(kakao);

        return new InMemoryClientRegistrationRepository(registrations);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll();
        http.oauth2Login();
        http.logout()
                .logoutSuccessUrl("/");
    }
}
