package uz.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.library.exception.NegativeNumberException;
import uz.library.service.NumberService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    private NumberService numberService;

    @Test
    @DisplayName("First parameter is greater than second one!")
    void calculate_when_first_is_greater_than_second() {
        int result = numberService.calculate(10, 5);

        assertEquals(result, 10 / 5, "Error in calculate method!");
    }

    @Test
    @DisplayName("Both parameters are equal!")
    void calculate_when_both_are_equal() {
        int result = numberService.calculate(1, 1);

        assertEquals(result, 0, "Parameters are not equal!");
    }

    @Test
    @DisplayName("First parameter is less than zero or equals to zero!")
    void calculate_when_first_is_less_than_zero() {

        assertThrows(NumberFormatException.class, () -> numberService.calculate(0, -12));
        assertThrowsExactly(NegativeNumberException.class, () -> numberService.calculate(0, -12));
    }

}
