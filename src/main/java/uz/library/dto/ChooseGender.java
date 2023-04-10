package uz.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ChooseGender {

    MALE("MALE"),
    FEMALE("FEMALE");

    ChooseGender(String name){
        this.name = name;
    }

    private final String name;
}
