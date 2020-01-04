package be.goodgid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * ## 200102 (Fri)
     * @EnableWebMvc를 사용하면
     * ViewResolver 값이 자동으로 등록된다.
     * 등록된 세팅을 A라고 하자.
     *
     * 그런데 A의 값에 추가적인 세팅을 더 하고 싶다.
     * 하지만
     * @EnableWebMvc만 사용하는 경우에는 불가능하다.
     *
     * 만약 추가적인 세팅이 필요하다면
     * A 세팅과 똑같은 Bean을 구현하고
     * 거기에 원하는 추가적인 세팅을 해서
     * customViewResolver()과 같은
     * Bean을 직접 정의해야한다.
     *
     * 매우 불편하다.
     *
     * 그래서
     * WebMvcConfigurer를 사용한다.
     *
     * WebMvcConfigurer를 사용하면
     * @EnableWebMvc가 세팅해주는 값에
     *
     * 추가적인 세팅들을
     * Override가 가능하다.
     *
     * configureViewResolvers() 와 customViewResolver()는 같은 역할을 한다.
     * configureViewResolvers() = @EnableWebMvc 세팅 값 + 사용자에 의한 추가 세팅
     * customViewResolver = @EnableWebMvc 세팅 값 직접 구현 + 사용자에 의한 추가 세팅
     *
     * */
























    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/","WebMvcConfigurer 구현");
    }




















//    @Bean
//    public ViewResolver customViewResolver() {
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/");
//        internalResourceViewResolver.setSuffix("WebMvcConfigurer 구현 X");
//        return internalResourceViewResolver;
//    }















}
