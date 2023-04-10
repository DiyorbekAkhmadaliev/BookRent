package uz.library.service.mapper;

import org.mapstruct.Mapper;
import uz.library.dto.BookDto;
import uz.library.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper extends CommonMapper<BookDto, Book>{
}
