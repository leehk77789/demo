package spring.basic.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.basic.demo.repository.JdbcMemberRepository;
import spring.basic.demo.repository.MemberRepositoryInterface;

import javax.sql.DataSource;

public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
    controller는 이 페이지에 모으지 않습니다.
    왜냐하면 원래부터 스프링 관할
     */

    public MemberService memberService() {
        return new MemberService(memberRepositoryInterface());
    }

    public MemberRepositoryInterface memberRepositoryInterface() {
        return new JdbcMemberRepository(dataSource);
    }
}
