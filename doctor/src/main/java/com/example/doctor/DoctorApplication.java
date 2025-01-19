package com.example.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = DoctorApplication.class)

public class DoctorApplication {

	public static void main(String[] args) {
		ApplicationModules.of(DoctorApplication.class).verify();
		SpringApplication.run(DoctorApplication.class, args);
	}

}
