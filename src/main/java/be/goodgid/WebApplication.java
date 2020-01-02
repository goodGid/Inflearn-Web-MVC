package be.goodgid;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        /***
         * ## 200101 (수)
         *
         * WebConfig에서
         * @EnableWebMvc 어노테이션을 사용하려면
         * context.setServletContext() 코드가 반드시 필요하다.
         * Reference : be.goodgid.WebConfig
         *
         * ## Why?
         * @EnableWebMvc -> DelegatingWebMvcConfiguration -> WebMvcConfigurationSupport
         * 경로를 따라 들어가면
         * servletContext를 참조하는 곳이 있다.
         * 그렇기 때문에
         * ServletContext을 설정해주지 않으면
         * 정상적으로
         * Bean 설정이 되지 않는다.
         * Reference : org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
         */
        context.setServletContext(servletContext);
        context.register(WebConfig.class);
        context.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app = servletContext.addServlet("dispatcher", dispatcherServlet);
        app.addMapping("/");
    }
}

// 실제로 값 변경 유무 정리
// 인터셉터에 추가된것들이 어디서 추가되엇는지 스샷
