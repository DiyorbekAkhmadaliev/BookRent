package uz.library.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.library.dto.CategoryDto;
import uz.library.dto.ResponseDto;
import uz.library.model.Category;
import uz.library.repository.CategoryRepository;
import uz.library.service.CategoryService;
import uz.library.service.mapper.CategoryMapper;
import uz.library.service.validator.AppStatusCodes;
import uz.library.service.validator.AppStatusMessages;

import java.util.List;
import java.util.Optional;

import static uz.library.service.validator.AppStatusCodes.*;
import static uz.library.service.validator.AppStatusMessages.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ResponseDto<CategoryDto> addCategory(CategoryDto categoryDto) {
        try {
            return ResponseDto.<CategoryDto>builder()
                    .data(categoryMapper.toDto(
                            categoryRepository.save(
                                    categoryMapper.toEntity(categoryDto))))
                    .message(OK)
                    .success(true)
                    .code(OK_CODE)
                    .build();
        }catch (Exception e){
            return ResponseDto.<CategoryDto>builder()
                    .message(DATABASE_ERROR + " " + e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .data(categoryDto)
                    .build();
        }
    }

    @Override
    public ResponseDto<List<CategoryDto>> getCategoryById(Integer categoryId) {

        Optional<Category> optional = categoryRepository.findById(categoryId);

        if (optional.isEmpty()){
            return ResponseDto.<List<CategoryDto>>builder()
                    .message(NOT_FOUND)
                    .code(NOT_FOUND_ERROR_CODE)
                    .build();
        }

        return ResponseDto.<List<CategoryDto>>builder()
                .message(OK)
                .code(OK_CODE)
                .success(true)
                .data(optional.stream().map(categoryMapper::toDto).toList())
                .build();
    }
}
