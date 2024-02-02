package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import hello.hello.spring.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//interface가 interface를 상속받으려면 extends 사용
//interface는 다중 상속이 가능
//<T, ID>

//spring data Jpa가 JpaRepository를 받고 있으면 SpringDataJpa가 interface에 대한 구현체를 자동으로 만들어서 spring bean에 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String>, MemberRepository{
    @Override
    Optional<Member> findByName(String name); //기본 메소드에서 추가!!!!
    @Query("SELECT t FROM ToDo t WHERE t.fid = :fid")
    List<ToDo> findAllByFid(@Param("fid") String fid);

}
