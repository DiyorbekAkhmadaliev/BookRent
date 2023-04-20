package uz.library.service.Impl;

import org.springframework.http.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.library.dto.GoogleOAuth2UserInfo;
import uz.library.dto.OAuth2UserInfo;
import uz.library.dto.UserDto;

import java.util.Collections;

@Service
public class GoogleUserDetailsService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserInfo userInfo = getOAuth2UserInfo(userRequest);
        UserDto user = new UserDto();
        user.setUsername(userInfo.getEmail());
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("USER")),
                userInfo.getAttributes(), userInfo.getNameAttributeKey());
    }

    private OAuth2UserInfo getOAuth2UserInfo(OAuth2UserRequest userRequest) {
        String userInfoUri = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUri();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + userRequest.getAccessToken().getTokenValue());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<GoogleOAuth2UserInfo> response = new RestTemplate().exchange(userInfoUri, HttpMethod.GET,
                entity, GoogleOAuth2UserInfo.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error("google_user_info_error", "Error retrieving user info from Google", null));
        }
    }
}

