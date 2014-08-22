package se.r2m.spring.ovning5;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;

import se.r2m.spring.ovning5.servlet.ListSpringBeansServlet;

public class Main {

    public static void main(final String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort( 8080 );
        Context context = addContext( tomcat.getHost(), "/", new File("WebContent/").getAbsolutePath() );
        tomcat.start();
        tomcat.getServer().await();
	}
    
    public static Context addContext(Host host, String contextPath, String dir) {
        Context context = null;
        context = new StandardContext();
        context.setName(contextPath);
        context.setPath(contextPath);
        context.setDocBase(dir);
        context.setRealm(host.getRealm());
        ContextConfig contextConfig = new ContextConfig();
        context.addLifecycleListener(contextConfig);
        host.addChild(context);
        return context;
    }
    
    public static class AppInitializer implements WebApplicationInitializer {

        @Override
        public void onStartup(ServletContext context) throws ServletException {
        	AnnotationConfigApplicationContext springctx = new AnnotationConfigApplicationContext("se");
        	ServletRegistration.Dynamic dispatcher = 
        			context.addServlet("Simple", new ListSpringBeansServlet(springctx) );
		    dispatcher.setLoadOnStartup(1);
		    dispatcher.addMapping("/*");
        }
    }
}
