package uz.library.service;

import uz.library.dto.CategoryDto;
import uz.library.dto.ResponseDto;
import uz.library.model.Category;

import java.util.List;

public interface CategoryService {
    ResponseDto<CategoryDto> addCategory(CategoryDto categoryDto);
    ResponseDto<List<CategoryDto>> getCategoryById(Integer categoryId);
}
