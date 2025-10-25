package com.example.library.service;


import com.example.library.dto.BookDTO;
import com.example.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Flux<BookDTO> getAllBooks() {
        Flux<BookDTO> books = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/api/books")
                .retrieve()
                .bodyToFlux(BookDTO.class);
        return books;
    }

}
