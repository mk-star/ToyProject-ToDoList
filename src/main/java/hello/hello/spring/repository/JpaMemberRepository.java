//package hello.hello.spring.repository;
//
//import hello.hello.spring.domain.Member;
//import jakarta.persistence.EntityManager;
//
//import java.util.List;
//import java.util.Optional;
//
////저장, 조회, 갱신 등 SQL을 직접 짤 필요 X
////Jpa를 (join)쓰려면 모든 데이터 변경이 항상 트랜잭션 안에서 실행이 되어야함!
//
//public class JpaMemberRepository implements MemberRepository{
//    private final EntityManager em;
//
//    //build.gradle에서 jpa 라이브러리 받으면 스프링부트가 EntityManger가 자동 생성, DI(주입)
//    public JpaMemberRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    //이렇게만 하면 DB에서 insert쿼리, setId 다 해줌
//    @Override
//    public Member save(Member member) {
//        em.persist(member); //영구 저장한다는 뜻
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(String id) {
//        Member member =  em.find(Member.class, id);
//        //find(조회할 타입, 식별자(pk))
//        return Optional.ofNullable(member);
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//
//        return result.stream().findAny(); //Optional이라서
//    }
//
//    @Override
//    public List<Member> findAll() {
//        List<Member> result = em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//        //spQl? 테이블이 아닌 Entity를 대상으로 쿼리를 날림 -> SQL로 번역
//        //select m(객체)
//        return result;
//    }
//}
