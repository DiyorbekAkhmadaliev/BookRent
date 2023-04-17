package uz.library.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NegativeNumberException extends NumberFormatException{

    int number;

    public NegativeNumberException(String s, int number) {
        super(s);
        this.number = number;
    }
}
