package uz.library.service.mapper;

import org.mapstruct.Mapper;
import uz.library.dto.CategoryDto;
import uz.library.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CommonMapper<CategoryDto, Category> {
}
