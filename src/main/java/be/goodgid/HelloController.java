package be.goodgid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello " + helloService.getName();
    }

    /**
     * 191230 (Mon)
     * handler = RequestMappingHandlerMapping
     * handlerAdapter = RequestMappingHandlerAdapter
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
     * SimpleController와 차이점을 파악하자.
     */

    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }
}
