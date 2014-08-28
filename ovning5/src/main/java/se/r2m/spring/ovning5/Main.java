package se.r2m.spring.ovning5;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.Context;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.JarScanFilter;
import org.apache.tomcat.JarScanType;
import org.apache.tomcat.JarScanner;
import org.apache.tomcat.JarScannerCallback;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.r2m.spring.ovning5.servlet.ListSpringBeansServlet;

public class Main {

	public static void main(final String[] args) throws Exception {
		File docBase = new File(System.getProperty("java.io.tmpdir"));
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		Context context = tomcat.addContext(tomcat.getHost(), "/", "SpringTutorial", docBase.getAbsolutePath());
		context.addLifecycleListener(new ContextConfig());
		context.addServletContainerInitializer(new AppInitializer(), new HashSet<Class<?>>());
		context.setJarScanner(new DoNothingJarScanner());
		tomcat.start();
		tomcat.getServer().await();
	}

	public static class AppInitializer implements ServletContainerInitializer {
		@Override
		public void onStartup(Set<Class<?>> c, ServletContext context) throws ServletException {
			AnnotationConfigApplicationContext springctx = new AnnotationConfigApplicationContext("se");
			ServletRegistration.Dynamic dispatcher =
					context.addServlet("SpringTutorialServlet", new ListSpringBeansServlet(springctx));
			dispatcher.setLoadOnStartup(1);
			dispatcher.addMapping("/*");
		}
	}

	public static class DoNothingJarScanner implements JarScanner {
		@Override
		public void scan(JarScanType scanType, ServletContext context, JarScannerCallback callback) {
		}

		@Override
		public JarScanFilter getJarScanFilter() {
			return null;
		}

		@Override
		public void setJarScanFilter(JarScanFilter jarScanFilter) {
		}
	}
}
