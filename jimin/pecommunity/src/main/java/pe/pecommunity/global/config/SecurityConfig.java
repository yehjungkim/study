package pe.pecommunity.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.pecommunity.domain.member.domain.Role;
import pe.pecommunity.global.config.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt 해시 함수를 이용하여 패스워드를 암호화하는 구현체
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/", "/members/new", "/members/login", "/resources/**").permitAll()
            .antMatchers("/login-test").hasRole(Role.ADMIN.name())
//            .antMatchers("/loginHome").authenticated()
//            .antMatchers("/members/**").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN") // 관리자만 접근 가능
        .and()
            .formLogin()
            .loginPage("/members/login") // 로그인 페이지
            .loginProcessingUrl("/members/login") // 로그인 요청 URI 매핑
            .usernameParameter("loginId")
            .passwordParameter("password")
            .defaultSuccessUrl("/loginHome", true) // 로그인 성공 시, 리다이렉트
            .failureUrl("/");

        http.logout().logoutUrl("/members/logout").logoutSuccessUrl("/"); // 로그아웃

        http.userDetailsService(userDetailsService);
    }
}
