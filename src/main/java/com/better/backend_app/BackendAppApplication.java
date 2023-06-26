package com.better.backend_app;

import com.better.backend_app.models.ActivityDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendAppApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BackendAppApplication.class, args);

	}

}
