//package hello.hello.spring.service;
//
//import hello.hello.spring.domain.Member;
//import hello.hello.spring.repository.MemoryMemberRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MemberServiceTest {
//
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    //메소드가 동작하기 전에? 각 테스트가 실행하기 전에 <> afterEach
//    @BeforeEach
//    public void beforEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEaach() {
//        memberRepository.clearStore(); //테스트가 하나하나 끝날 때마다 store을 clear함
//    }
//
//    @Test
//    void join() {
//        //given
//        Member member = new Member();
//        member.setName("spring");
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
//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
//}