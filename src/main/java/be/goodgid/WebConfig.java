package be.goodgid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;

        /**
         * 191230 (Mon)
         * be.goodgid.HelloController#sample()
         * be.goodgid.SimpleController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
         * view가 필요한 핸들러에서
         * view Name을 return 시
         * "WEB-INF/sample.jsp" or "WEB-INF/simple.jsp"로 하였다.
         *
         * 그런데 이제
         * 내가 정의한 viewResolver에서
         * Prefix / Suffix를
         *
         * 기본값으로 정의하였기 때문에
         * view가 필요한 핸들러에서
         * view Name을 return 시
         * view Name만 명시해줘도 된다.
         */
    }
}
