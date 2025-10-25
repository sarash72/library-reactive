package com.example.library.controller;


import com.example.library.dto.BookDTO;
import com.example.library.service.MemberService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public Flux<BookDTO> getAllBooks() {

        System.out.println("Thread in getAllBooks.......................: " + Thread.currentThread().getName());
        Flux<BookDTO> books= memberService.getAllBooks();
        System.out.println("books in member service: " + books);
        return books;
    }
}
