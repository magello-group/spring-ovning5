package se.r2m.spring.ovning5;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.r2m.spring.ovning5.servlet.ListSpringBeansServlet;

public class Main {

    public static void main(final String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort( 8080 );
        Context context = addContext( tomcat.getHost(), "/", new File("WebContent/").getAbsolutePath() );
    	AnnotationConfigApplicationContext springctx = new AnnotationConfigApplicationContext("se");
        Tomcat.addServlet( context, "Simple", new ListSpringBeansServlet(springctx) );
        context.addServletMapping( "/*", "Simple" );
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

}
