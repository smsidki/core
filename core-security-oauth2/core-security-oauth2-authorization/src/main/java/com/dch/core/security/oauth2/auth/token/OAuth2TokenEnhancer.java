package com.dch.core.security.oauth2.auth.token;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used to enhance access token.
 *
 * @author David.Christianto
 * @version 2.0.0
 * @see org.springframework.security.oauth2.provider.token.TokenEnhancer
 * @since 1.0.0
 */
public class OAuth2TokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        // TODO Add your additional information to access token
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("organization", authentication.getName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }

}
