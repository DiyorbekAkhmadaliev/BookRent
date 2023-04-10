package uz.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsDto {
    private String publisher;
    private LocalDate publishDate;
    private Integer pages;
    private String dimensions;
    private String language;
    private String type;
    private String ISBN;

}
