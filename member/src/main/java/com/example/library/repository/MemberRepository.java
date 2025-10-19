package com.example.library.repository;

import com.example.library.model.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, Long> {

    Flux<Member> findMemberByFullName(String fullName);




}
