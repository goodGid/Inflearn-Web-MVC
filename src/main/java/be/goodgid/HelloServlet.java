package be.goodgid;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[Goodgid] : helloServlet Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("[Goodgid] : helloServlet doGet");

        String rootWebApplicationContextAttribute =
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(
                rootWebApplicationContextAttribute);

        HelloService helloService = context.getBean(HelloService.class);

        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello Servlet " + helloService.getName() + "</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("</html>");
    }

    private Object getName(){
        return getServletContext().getAttribute("name");
    }

    @Override
    public void destroy() {
        System.out.println("[Goodgid] : helloServlet Destroy");
    }
}
