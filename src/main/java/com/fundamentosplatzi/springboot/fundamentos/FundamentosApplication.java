package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.configuration.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.configuration.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	private MyBean myBean;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());


		try {
			//code
		} catch (Exception e) {
			LOGGER.error("Esto es un error del aplicativo");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

}
