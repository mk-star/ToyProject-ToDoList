package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String id);
    Optional<Member> findByName(String name);

    Optional<Member> findByEmail(String email);
    List<Member> findAll();
}
