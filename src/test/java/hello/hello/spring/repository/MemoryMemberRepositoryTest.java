//package hello.hello.spring.repository;
//
//import hello.hello.spring.domain.Member;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//
//class MemoryMemberRepositoryTest {
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    //테스트는 순서와 관계없이, 즉 의존관계 없이 설계되어야 한다.
//    //그러기 위해서 하나의 테스트가 끝날 때마다 공용 data, 저장소 등을 clear 시켜줘야 함.
//    //각 메소드가 끝나고 호출됨.
//    @AfterEach
//    public void afterEaach() {
//        repository.clearStore(); //테스트가 하나하나 끝날 때마다 store을 clear함
//
//    }
//    @Test
//    public void save() {
//        Member member = new Member();
//        member.setName("spring");
//
//        repository.save(member);
//
//        Member result = repository.findById(member.getId()).get();
//       //System.out.println("result = " + (result == member));
//        // result = true/false 출력
//       // Assertions.assertEquals(member, result);
//        // true -> test success, false -> test fail
//
//        Assertions.assertThat(member).isEqualTo(result);
//        //
//    }
//
//    @Test
//    public void findByName() {
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        Member spring1 = repository.findByName("spring1").get();
//
//        Assertions.assertThat(spring1).isEqualTo(member1);
//    }
//
//    @Test
//    public void findAll(){
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        List<Member> result = repository.findAll();
//
//        Assertions.assertThat(result.size()).isEqualTo(2);
//    }
//}
