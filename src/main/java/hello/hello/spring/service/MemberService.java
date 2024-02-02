package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.exception.MemberNotFoundException;
import hello.hello.spring.exception.PasswordMismatchException;
import hello.hello.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    //service, Test에서 같은 MemoryMemberRepository가 사용됨.
    //외부에서 넣어줌 -> DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){
        //같은 이름이 있는 중복 회원 허용X
        //1번 방법(권장 X)
        // Optional<Member> result = memberRepository.findByName(member.getName());
        //result가 null이 아니라 값이 있으면
        //result.ifPresent(m -> { //null일 가능성이 있으면 Optional으로 감싸서 반환
        //    throw new IllegalStateException("이미 존재하는 회원입니다.");
        //});
        memberRepository.save(member);
        return member.getId();
    }

    //회원 로그인
    public Member login(String id, String password){
        System.out.println(id);
        System.out.println(password);
        Optional<Member> member = findMember(id);

        if(member.isPresent()) {
            return member.get();
        }

        return null;
    }

    //전체 회원조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //아이디로 회원조회
    public Optional<Member> findMember(String id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
