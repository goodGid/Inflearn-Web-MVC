package goodgid.gidhub;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 등록된 순서대로 실행
         */
//        registry.addInterceptor(new GreetingInterceptor());
//        registry.addInterceptor(new GoodByeInterceptor());

        /***
         * [1] GreetingInterceptor preHandle
         * [2] GoodByeInterceptor preHandle
         * [2] GoodByeInterceptor postHandle
         * [1] GreetingInterceptor postHandle
         * [2] GoodByeInterceptor afterCompletion
         * [1] GreetingInterceptor afterCompletion
         */

        /***
         * Order 설정
         */
//        registry.addInterceptor(new GreetingInterceptor()).order(0);
//        registry.addInterceptor(new GoodByeInterceptor()).order(-1);
        /**
         * [2] GoodByeInterceptor preHandle
         * [1] GreetingInterceptor preHandle
         * [1] GreetingInterceptor postHandle
         * [2] GoodByeInterceptor postHandle
         * [1] GreetingInterceptor afterCompletion
         * [2] GoodByeInterceptor afterCompletion
         */

        /***
         * Pattern 명시
         */
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new GoodByeInterceptor())
                .addPathPatterns("/hi")
                .order(-1);
        /***
         * [1] GreetingInterceptor preHandle
         * [1] GreetingInterceptor postHandle
         * [1] GreetingInterceptor afterCompletion
         */

    }
}
