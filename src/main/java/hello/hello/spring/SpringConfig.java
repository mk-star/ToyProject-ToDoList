package hello.hello.spring;

import hello.hello.spring.repository.*;
import hello.hello.spring.service.MemberService;
import hello.hello.spring.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ToDoRepository toDoRepository;

    //DI -> spring data Jpa가 구현체를 만들어놓은 게 등록이 됨

    @Autowired //스프링 컨테이너에서 memberRepository를 찾음, springDataJpaMemberRepository에서 spring beana에 등록된 구현체를 주입
    public SpringConfig(MemberRepository memberRepository, ToDoRepository toDoRepository) {
        this.memberRepository = memberRepository;
        this.toDoRepository = toDoRepository;
    }


    //받은 memberRepository를 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public ToDoService toDoService() {
        return new ToDoService(toDoRepository);
    }


//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public ToDoRepository todoRepository() {
//        return new JpaTodoRepository();
//    }

  //  @Bean
  //  public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
  //  }
}
