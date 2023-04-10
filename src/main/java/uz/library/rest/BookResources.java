package uz.library.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.library.dto.BookDto;
import uz.library.dto.ResponseDto;
import uz.library.service.BookServices;
import uz.library.service.Impl.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookResources {

    private final BookServices bookServices;

    @PostMapping
    public ResponseDto<BookDto> addBook(@RequestBody @Valid BookDto dto){
        return bookServices.addBook(dto);
    }

    @GetMapping("by-id")
    public ResponseDto<BookDto> getById(@RequestParam Integer id){
        return bookServices.getBookById(id);
    }

    @GetMapping
    public ResponseDto<List<BookDto>> getAllBooks(){
        return bookServices.getAllBooks();
    }

    @PatchMapping
    public ResponseDto<BookDto> updateBook(@RequestBody BookDto dto){
        return bookServices.updateBook(dto);
    }

    @DeleteMapping
    public ResponseDto<Void> deleteBook(@RequestParam Integer id){
        return bookServices.deleteBook(id);
    }
}
