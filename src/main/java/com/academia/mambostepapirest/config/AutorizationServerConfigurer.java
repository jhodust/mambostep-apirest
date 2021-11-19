package com.academia.mambostepapirest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AutorizationServerConfigurer extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private InfoAdicionalToken infoAdicionalToken;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient("angularapp")
		.secret(passwordEncoder.encode("12345"))
		.scopes("read","write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		TokenEnhancerChain tokenEnhacerChain = new TokenEnhancerChain();
		tokenEnhacerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		
		endpoints.authenticationManager(this.authenticationManager)
		.accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhacerChain);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		// TODO Auto-generated method stub
		JwtAccessTokenConverter jwtAccessTokenConverter= new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JWTConfig.PRIVATE_KEY);
		jwtAccessTokenConverter.setVerifierKey(JWTConfig.PUBLIC_KEY);
		return jwtAccessTokenConverter;
	}
	
	
	
}
