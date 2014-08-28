package se.r2m.spring.ovning5.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class SpringConfig {

	@Bean(destroyMethod = "shutdown")
	public EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder().
				setType(EmbeddedDatabaseType.HSQL).
				addScript("db/initDB.sql").
				addScript("db/populateDB.sql").
				build();
	}
}
