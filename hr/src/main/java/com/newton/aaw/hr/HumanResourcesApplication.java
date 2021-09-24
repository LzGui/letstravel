package com.newton.aaw.hr;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HumanResourcesApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(HumanResourcesApplication.class).registerShutdownHook(true).run(args);
	}

}
