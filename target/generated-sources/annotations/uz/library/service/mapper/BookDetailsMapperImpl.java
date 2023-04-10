package uz.library.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.library.dto.BookDetailsDto;
import uz.library.model.BookDetails;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T17:38:58+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookDetailsMapperImpl implements BookDetailsMapper {

    @Override
    public BookDetailsDto toDto(BookDetails e) {
        if ( e == null ) {
            return null;
        }

        BookDetailsDto bookDetailsDto = new BookDetailsDto();

        bookDetailsDto.setPublisher( e.getPublisher() );
        bookDetailsDto.setPublishDate( e.getPublishDate() );
        bookDetailsDto.setPages( e.getPages() );
        bookDetailsDto.setDimensions( e.getDimensions() );
        bookDetailsDto.setLanguage( e.getLanguage() );
        bookDetailsDto.setType( e.getType() );
        bookDetailsDto.setISBN( e.getISBN() );

        return bookDetailsDto;
    }

    @Override
    public BookDetails toEntity(BookDetailsDto d) {
        if ( d == null ) {
            return null;
        }

        BookDetails bookDetails = new BookDetails();

        bookDetails.setPublisher( d.getPublisher() );
        bookDetails.setPublishDate( d.getPublishDate() );
        bookDetails.setPages( d.getPages() );
        bookDetails.setDimensions( d.getDimensions() );
        bookDetails.setLanguage( d.getLanguage() );
        bookDetails.setType( d.getType() );
        bookDetails.setISBN( d.getISBN() );

        return bookDetails;
    }
}
