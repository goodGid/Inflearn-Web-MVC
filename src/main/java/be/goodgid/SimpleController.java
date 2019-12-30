package be.goodgid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 191230 (Mon)
 * BeanNameUrlHandlerMapping을 사용한 방법
 * 일반적으로 우리가 사용하는 Annotation 기반은
 * RequestMappingHandlerMapping을 사용한다.
 */
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {

    /**
     * 191230 (Mon)
     * handler = BeanNameUrlHandlerMapping
     * handlerAdapter = SimpleControllerHandlerAdapter
     *
     * doDispatch()
     * org.springframework.web.servlet.DispatcherServlet#doDispatch(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     *
     * getHandler()
     * org.springframework.web.servlet.DispatcherServlet#getHandler(javax.servlet.http.HttpServletRequest)
     *
     * getHandlerAdapter()
     * org.springframework.web.servlet.DispatcherServlet#getHandlerAdapter(java.lang.Object)
     *
     * be.goodgid.HelloController#sample()와의 차이점에 대해 알아놓자.
     */

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return new ModelAndView("simple");
    }
}
