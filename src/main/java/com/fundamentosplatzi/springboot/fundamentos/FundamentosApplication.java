package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	public FundamentosApplication(@Qualifier("ComponentTwoImplement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

}