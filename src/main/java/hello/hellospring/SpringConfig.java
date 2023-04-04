package hello.hellospring;


import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
 //
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }



//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//        //return new JdbcTemplateMemberRepository(dataSource);
//
//    }
}
    //db연결을 하게 되면 MemoryMemberRepository()을 DbMemberRepository() 교체
