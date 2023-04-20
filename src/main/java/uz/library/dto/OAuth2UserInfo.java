package uz.library.dto;

import java.util.Map;

public interface OAuth2UserInfo {

    String getEmail();

    String getFirstName();

    String getLastName();

    String getNameAttributeKey();

    Map<String, Object> getAttributes();
}

