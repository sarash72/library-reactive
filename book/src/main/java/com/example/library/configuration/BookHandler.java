package com.example.library.configuration;


import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Component
public class BookHandler {

    private final BookService bookService;


    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest request) {
        return ServerResponse.ok()
                .body(bookService.getAllBooks(), Book.class);
    }

    public Mono<ServerResponse> createBook(ServerRequest request) {
        return request.bodyToMono(Book.class)
                .flatMap(bookService::saveBook)
                .flatMap(savedBook -> ServerResponse.ok().bodyValue(savedBook))
                .onErrorResume(e ->
                        ServerResponse.badRequest().bodyValue("Error: " + e.getMessage()));
    }
}
