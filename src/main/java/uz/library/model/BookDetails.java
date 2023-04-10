package uz.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class BookDetails {
    @Id
    @GeneratedValue(generator = "book_details_id_seq")
    @SequenceGenerator(name = "book_details_id_seq", sequenceName = "book_details_id_seq", allocationSize = 1)
    private Integer id;
    private String publisher;
    private LocalDate publishDate;
    private Integer pages;
    private String dimensions;
    private String language;
    private String type;
    private String ISBN;
}
