package se.r2m.spring.ovning5.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import se.r2m.spring.ovning5.bean.GeneralMethods;
  
public class ListSpringBeansServlet extends HttpServlet {  
    
	private static final long serialVersionUID = 1L;
	
	private ApplicationContext ctx;  
  
	public ListSpringBeansServlet(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                            throws ServletException, IOException {  
  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        out.print("<html><body><h1>");  
        out.print(ctx.getBean(GeneralMethods.class).greetingString());  
        out.print("</h1><h3>Följande bönor finns definierade</h3>");  
        out.print("<ul>");  
        for (String bean : ctx.getBeanDefinitionNames()) {
            out.print("<li>" + bean + "</li>");  
		}
        out.print("</ul></body></html>");  
    }  
}  