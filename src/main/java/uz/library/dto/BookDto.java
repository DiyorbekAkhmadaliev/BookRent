package uz.library.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import static uz.library.service.validator.AppStatusMessages.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    @NotNull(message = NULL_VALUE)
    private String title;
    @NotNull(message = NULL_VALUE)
    private String author;
    @NotNull(message = NULL_VALUE)
    @Min(value = 0, message = NEGATIVE_VALUE)
    private Double price;
    @NotNull(message = NULL_VALUE)
    @Min(value = 0, message = NEGATIVE_VALUE)
    private Integer amount;
    @NotNull(message = EMPTY_STRING)
    private String description;
    private BookDetailsDto details;
    private MultipartFile bookImage;
    private boolean isAvailable;

}
