package be.goodgid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class WebConfig {

    /**
     * 200101 (수)
     * 다음처럼 코딩하면
     * DispatcherServlet.properties의 기본전략을 사용하는 것과 같다.
     *
     * 즉 handlerMapping Bean을
     * 다음처럼만 정의할꺼면
     * (= handlerMapping() )
     * 할 필요가 없다.
     * Why?
     * DispatcherServlet이 생성될 때 기본 전략을
     * 자동으로 등록시켜주기 때문이다.
     *
     * Reference : repository/org/springframework/spring-webmvc/5.2.2.RELEASE/spring-webmvc-5.2.2.RELEASE-sources.jar!/org/springframework/web/servlet/DispatcherServlet.java:283
     *
     * 하지만
     * viewResolver() 같은 경우엔
     * 기본 전략에서는
     * Prefix / Suffix의 값이 없기 때문에
     * 이렇게 Bean을 정의하면
     * 유용하게 사용할 수 있다.
     */
    @Bean
    public HandlerMapping handlerMapping(){
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        return handlerMapping;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
