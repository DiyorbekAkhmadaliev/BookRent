package uz.library.service.mapper;

import org.mapstruct.Mapper;
import uz.library.dto.BookDetailsDto;
import uz.library.model.BookDetails;
@Mapper(componentModel = "spring")
public interface BookDetailsMapper extends CommonMapper<BookDetailsDto, BookDetails>{
}
