package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.BookStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface  BookRepository extends ReactiveCrudRepository<Book, Long> {

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByStatus(BookStatus bookStatus);

    Flux<Book> findByTitle(String title);



}
