package com.project.PdfDigitalSign;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PdfDigitalSignApplication extends SpringBootServletInitializer {

	private static final Logger logger = LogManager.getLogger(PdfDigitalSignApplication.class);

	public static void main(String[] args) {
		logger.info("=======RUN_FILE_SIGNER_APPLICATION======");
		SpringApplication.run(PdfDigitalSignApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PdfDigitalSignApplication.class);
	}
}
