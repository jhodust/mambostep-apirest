package com.academia.mambostepapirest.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.services.IPersonaService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IPersonaService personaService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		PersonaDto persona=personaService.searchPersonaByUsername(authentication.getName());
		Map<String,Object> info= new HashMap<String, Object>();
		info.put("nombre", persona.getNombre());
		info.put("id", persona.getId());
		info.put("identificacion", persona.getIdentificacion());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info); 
		
 		return accessToken;
	}

}
