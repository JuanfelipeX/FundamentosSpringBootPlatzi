package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithProperties myBeanWithProperties;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithProperties myBeanWithProperties){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithProperties = myBeanWithProperties;
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		System.out.println(myBeanWithProperties.function());

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

}
