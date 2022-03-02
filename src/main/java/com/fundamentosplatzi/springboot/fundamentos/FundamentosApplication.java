package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.configuration.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.configuration.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	private MyBean myBean;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private UserRepository userRepository;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUserInDataBase();
		getInformationJqplFromUser();

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private void saveUserInDataBase(){
		User user1 = new User("jhon", "john69@konrda.com", LocalDate.of(2022, 03, 03));
		User user2 = new User("felipe", "felipe@gmail.com", LocalDate.of(2021, 23, 02));
		User user3 = new User("jimene", "jimene@yahoo.com", LocalDate.of(2024, 12, 05));
		User user4 = new User("pacheco", "pacheco@konra.com", LocalDate.of(2024, 04, 04));

		List<User> list = Arrays.asList(user1, user2, user3, user4);
		list.stream().forEach(userRepository::save);

	}

	private void getInformationJqplFromUser(){
		LOGGER.info("Usuario con el metodo findByUserEmail  " +
				userRepository.findByUserEmail("john69@konrda.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
		userRepository.findByUserEmail("john69@konrda.com");

		userRepository.findByAndSort("user", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("Usuario con metodo  sort  " + user));
	}

	private void ejemplosAnteriores(){
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

}
