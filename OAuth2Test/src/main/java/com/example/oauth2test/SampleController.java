package com.example.oauth2test;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class SampleController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("dior")
    public Map<String, Object> oAuth2AuthenticationToken(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
}
