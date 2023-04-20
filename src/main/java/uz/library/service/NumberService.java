package uz.library.service;

import org.springframework.stereotype.Service;
import uz.library.exception.NegativeNumberException;

@Service
public class NumberService {

    public int calculate(int a, int b){
        if (a > b){
            if (a == 0){
                throw new NegativeNumberException("Number is less than 0 ", a);
            }
            return a / b;
        }
        if (a == b) return 0;

        return a + b;
    }
}
