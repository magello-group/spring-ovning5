package se.r2m.spring.ovning5;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.r2m.spring.ovning5.servlet.ListSpringBeansServlet;

public class Main {

    public static void main(final String[] args) throws Exception {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("se")) {
	        Tomcat tomcat = new Tomcat();
	        tomcat.setPort( 8080 );
	        Context context = tomcat.addContext( "/", new File("WebContent/").getAbsolutePath() );
	        Tomcat.addServlet( context, "Simple", new ListSpringBeansServlet(ctx) );
	        context.addServletMapping( "/*", "Simple" );
	        tomcat.start();
	        tomcat.getServer().await();
		}
	}
}
