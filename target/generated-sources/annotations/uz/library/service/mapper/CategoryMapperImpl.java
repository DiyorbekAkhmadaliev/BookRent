package uz.library.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.library.dto.CategoryDto;
import uz.library.model.Category;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T14:46:34+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category e) {
        if ( e == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( e.getId() );
        categoryDto.setName( e.getName() );
        categoryDto.setParentId( e.getParentId() );

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto d) {
        if ( d == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( d.getId() );
        category.setName( d.getName() );
        category.setParentId( d.getParentId() );

        return category;
    }
}
