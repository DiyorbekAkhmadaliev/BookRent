package uz.library.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.library.dto.CategoryDto;
import uz.library.dto.ResponseDto;
import uz.library.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryResources {

    private final CategoryService categoryService;

    @PostMapping
    ResponseDto<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping
    ResponseDto<List<CategoryDto>> getCategoryById(Integer categoryId){
        return categoryService.getCategoryById(categoryId);
    }
}
