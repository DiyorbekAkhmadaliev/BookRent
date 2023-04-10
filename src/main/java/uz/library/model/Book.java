package uz.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq",sequenceName = "book_id_seq", allocationSize = 1)
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer amount;
    @ManyToOne
    private Category category;
    private String description;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BookDetails details;
    private boolean isAvailable;
}
