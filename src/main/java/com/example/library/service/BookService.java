package com.example.library.service;


import com.example.library.model.Book;
import com.example.library.model.BookStatus;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Flux<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Mono<Book> updateBookStatus(Long id, BookStatus status) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Book not found")))
                .flatMap(book -> {
                    book.setStatus(status);
                    return bookRepository.save(book);
                });
    }
}
