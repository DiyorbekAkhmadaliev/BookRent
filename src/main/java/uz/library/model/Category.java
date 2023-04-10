package uz.library.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "category_id_seq")
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Book> books;
    private Integer parentId;
}
