package uz.library.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.library.dto.BookDetailsDto;
import uz.library.dto.BookDto;
import uz.library.model.Book;
import uz.library.model.BookDetails;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T17:38:58+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book e) {
        if ( e == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( e.getId() );
        bookDto.setTitle( e.getTitle() );
        bookDto.setAuthor( e.getAuthor() );
        bookDto.setPrice( e.getPrice() );
        bookDto.setAmount( e.getAmount() );
        bookDto.setDescription( e.getDescription() );
        bookDto.setDetails( bookDetailsToBookDetailsDto( e.getDetails() ) );
        bookDto.setAvailable( e.isAvailable() );

        return bookDto;
    }

    @Override
    public Book toEntity(BookDto d) {
        if ( d == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( d.getId() );
        book.setTitle( d.getTitle() );
        book.setAuthor( d.getAuthor() );
        book.setPrice( d.getPrice() );
        book.setAmount( d.getAmount() );
        book.setDescription( d.getDescription() );
        book.setDetails( bookDetailsDtoToBookDetails( d.getDetails() ) );
        book.setAvailable( d.isAvailable() );

        return book;
    }

    protected BookDetailsDto bookDetailsToBookDetailsDto(BookDetails bookDetails) {
        if ( bookDetails == null ) {
            return null;
        }

        BookDetailsDto bookDetailsDto = new BookDetailsDto();

        bookDetailsDto.setPublisher( bookDetails.getPublisher() );
        bookDetailsDto.setPublishDate( bookDetails.getPublishDate() );
        bookDetailsDto.setPages( bookDetails.getPages() );
        bookDetailsDto.setDimensions( bookDetails.getDimensions() );
        bookDetailsDto.setLanguage( bookDetails.getLanguage() );
        bookDetailsDto.setType( bookDetails.getType() );
        bookDetailsDto.setISBN( bookDetails.getISBN() );

        return bookDetailsDto;
    }

    protected BookDetails bookDetailsDtoToBookDetails(BookDetailsDto bookDetailsDto) {
        if ( bookDetailsDto == null ) {
            return null;
        }

        BookDetails bookDetails = new BookDetails();

        bookDetails.setPublisher( bookDetailsDto.getPublisher() );
        bookDetails.setPublishDate( bookDetailsDto.getPublishDate() );
        bookDetails.setPages( bookDetailsDto.getPages() );
        bookDetails.setDimensions( bookDetailsDto.getDimensions() );
        bookDetails.setLanguage( bookDetailsDto.getLanguage() );
        bookDetails.setType( bookDetailsDto.getType() );
        bookDetails.setISBN( bookDetailsDto.getISBN() );

        return bookDetails;
    }
}
