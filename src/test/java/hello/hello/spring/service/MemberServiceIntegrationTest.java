//package hello.hello.spring.service;
//
//import hello.hello.spring.domain.Member;
//import hello.hello.spring.repository.MemberRepository;
//import hello.hello.spring.repository.MemoryMemberRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest
//@Transactional
//public class MemberServiceIntegrationTest {
//
//    //필드 주입
//    //SpringConfig에 등록되어 있는 곳에서 올라옴
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    void join() {
//        //given
//        Member member = new Member();
//        member.setName("spring100");
//
//        //when
//        Long savedId = memberService.join(member);
//        //then
//        Member findMember = memberService.findOne(savedId).get();
//        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
//    }
//
//    @Test
//    public void 중복회원_예외() {
//        //given
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member2.setName("spring");
//
//        //when
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        //
//
//        //try {
//        //    memberService.join(member2);
//        //    fail();
//        //} catch (IllegalStateException e) {
//        //    Assertions.assertThat(e.getMessage()).isEqualTo(("이미 존재하는 회원입니다."));
//        //}
//
//        //memberService.join(member2);
//        //then
//    }
//}