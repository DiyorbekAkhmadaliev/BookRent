package uz.library.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.library.dto.BookDto;
import uz.library.dto.ResponseDto;
import uz.library.model.Book;
import uz.library.repository.BookRepository;
import uz.library.service.BookServices;
import uz.library.service.mapper.BookMapper;

import java.util.List;
import java.util.Optional;

import static uz.library.service.validator.AppStatusCodes.*;
import static uz.library.service.validator.AppStatusMessages.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServices {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public ResponseDto<BookDto> addBook(BookDto dto) {
        isNull(dto);

        Book book = bookMapper.toEntity(dto);
        book.setAvailable(true);
        try {
            Book entity = bookRepository.save(book);

            return ResponseDto.<BookDto>builder()
                    .code(OK_CODE)
                    .message(OK)
                    .success(true)
                    .data(bookMapper.toDto(entity))
                    .build();

        } catch (Exception e) {
            return ResponseDto.<BookDto>builder()
                    .code(DATABASE_ERROR_CODE)
                    .message(DATABASE_ERROR + " : " + e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<List<BookDto>> getAllBooks() {
        try {
            List<BookDto> list = bookRepository.findAll().stream().map(bookMapper::toDto).toList();
            return ResponseDto.<List<BookDto>>builder()
                    .code(OK_CODE)
                    .message(OK)
                    .success(true)
                    .data(list)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<List<BookDto>>builder()
                    .message(DATABASE_ERROR + " " + e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .build();
        }
    }

    @Override
    public ResponseDto<BookDto> updateBook(BookDto dto) {
        isNull(dto);

        Optional<Book> optional = bookRepository.findById(dto.getId());

        if (optional.isEmpty()) {
            return ResponseDto.<BookDto>builder()
                    .code(NOT_FOUND_ERROR_CODE)
                    .message(NOT_FOUND)
                    .build();
        }

        Book book = optional.get();

        setParams(dto, book);

        try {
            bookRepository.save(book);
            return ResponseDto.<BookDto>builder()
                    .message(OK)
                    .code(OK_CODE)
                    .success(true)
                    .data(bookMapper.toDto(book))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BookDto>builder()
                    .message(DATABASE_ERROR + " " + e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .build();
        }


    }

    @Override
    public ResponseDto<Void> deleteBook(Integer id) {
        isNull(id);
        try{
            bookRepository.deleteById(id);
            return ResponseDto.<Void>builder()
                    .success(true)
                    .message(OK)
                    .code(OK_CODE)
                    .build();
        }catch (Exception e){
            return ResponseDto.<Void>builder()
                    .message(DATABASE_ERROR +" "+ e.getMessage())
                    .code(DATABASE_ERROR_CODE)
                    .build();
        }
    }

    @Override
    public ResponseDto<BookDto> getBookById(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return ResponseDto.<BookDto>builder()
                    .message(NOT_FOUND)
                    .code(NOT_FOUND_ERROR_CODE)
                    .build();
        }
        return ResponseDto.<BookDto>builder()
                .message(OK)
                .code(OK_CODE)
                .success(true)
                .data(bookMapper.toDto(optional.get()))
                .build();
    }

    private <T> void isNull(T t) {
        if (t == null) {
            ResponseDto.<Void>builder()
                    .message(NULL_VALUE)
                    .code(VALIDATION_ERROR_CODE)
                    .build();
        }
    }

    private void setParams(BookDto dto, Book book) {
        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }
        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }
        if (dto.getPrice() != null && dto.getPrice() > 0) {
            book.setPrice(dto.getPrice());
        }
        if (dto.getAmount() != null && dto.getAmount() > 0) {
            book.setAmount(dto.getAmount());
        }
        if (dto.getDescription() != null) {
            book.setDescription(dto.getDescription());
        }
        if (dto.getDetails() != null) {
            if (dto.getDetails().getDimensions() != null) {
                book.getDetails().setDimensions(dto.getDetails().getDimensions());
            }
            if (dto.getDetails().getISBN() != null) {
                book.getDetails().setISBN(dto.getDetails().getISBN());
            }
            if (dto.getDetails().getPages() != null) {
                book.getDetails().setPages(dto.getDetails().getPages());
            }
            if (dto.getDetails().getType() != null) {
                book.getDetails().setType(dto.getDetails().getType());
            }
            if (dto.getDetails().getLanguage() != null) {
                book.getDetails().setLanguage(dto.getDetails().getLanguage());
            }
            if (dto.getDetails().getPublisher() != null) {
                book.getDetails().setPublisher(dto.getDetails().getPublisher());
            }
            if (dto.getDetails().getPublishDate() != null) {
                book.getDetails().setPublishDate(dto.getDetails().getPublishDate());
            }
        }
    }
}
