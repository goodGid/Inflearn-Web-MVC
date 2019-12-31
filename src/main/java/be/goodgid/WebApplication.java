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
        /**
         * AnnotationConfigWebApplicationContext를 인스턴스를 생성한다.
         */
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        /**
         * Config를 등록하는데 2가지 방법이 있다.
         * 1. context.setConfigLocation()
         * 2. context.register()
         * 어느것을 사용해도 상관없다.
         */
//        context.setConfigLocation("be.goodgid.WebConfig");
        context.register(WebConfig.class);
        context.refresh();

        /**
         * 위에서 생성한 AnnotationConfigWebApplicationContext 인스턴스를
         * DispatcherServlet.webApplicationContext의 값으로 세팅해준다.
         * // this.webApplicationContext = webApplicationContext;
         */
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app = servletContext.addServlet("dispatcher", dispatcherServlet);
        /**
         * addMapping()의 값으로 `/*`을 지정하면 안된다.
         * 자세한건 다음 글을 참고하자.
         * https://www.baeldung.com/spring-mvc-404-error
         */
//        app.addMapping("/*");
        app.addMapping("/");
    }
}
