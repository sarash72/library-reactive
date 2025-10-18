package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.model.BookStatus;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper; // Mapper inject شد

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public Mono<BookDTO> createBook(@RequestBody BookDTO dto) {
        Book book = bookMapper.toEntity(dto);
        if (book.getStatus() == null) {
            book.setStatus(BookStatus.AVAILABLE);
        }
        return bookService.saveBook(book)
                .map(bookMapper::toDTO);
    }

    @GetMapping
    public Flux<BookDTO> getAllBooks() {
        return bookService.getAllBooks()
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getStatus()));
    }
}
