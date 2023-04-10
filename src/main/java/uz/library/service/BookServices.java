package uz.library.service;

import uz.library.dto.BookDto;
import uz.library.dto.ResponseDto;
import uz.library.model.Book;

import java.util.List;

public interface BookServices {

    ResponseDto<BookDto> addBook(BookDto dto);
    ResponseDto<List<BookDto>> getAllBooks();
    ResponseDto<BookDto> updateBook(BookDto dto);
    ResponseDto<Void> deleteBook(Integer id);
    ResponseDto<BookDto> getBookById(Integer id);

}
