package trn.justin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Neo4JApplication {

	private static final Logger logger = LogManager.getLogger(Neo4JApplication.class);
	
	public static void main(String[] args) {
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"); 
		SpringApplication.run(Neo4JApplication.class, args);
		logger.debug("Debug Logging Test");
		logger.info("Info Logging Test");
		logger.warn("Warning Logging Test");
		logger.error("Error Logging Test");
		logger.fatal("Fatal Logging Test");
	}
}
