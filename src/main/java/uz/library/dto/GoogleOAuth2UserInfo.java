package uz.library.dto;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String FIRST_NAME_ATTRIBUTE = "given_name";
    private static final String LAST_NAME_ATTRIBUTE = "family_name";

    private Map<String, Object> attributes;

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getEmail() {
        return (String) attributes.get(EMAIL_ATTRIBUTE);
    }

    @Override
    public String getFirstName() {
        return (String) attributes.get(FIRST_NAME_ATTRIBUTE);
    }

    @Override
    public String getLastName() {
        return (String) attributes.get(LAST_NAME_ATTRIBUTE);
    }

    @Override
    public String getNameAttributeKey() {
        return "name";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}

