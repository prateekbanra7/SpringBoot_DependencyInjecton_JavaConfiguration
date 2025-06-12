package in.abc;



import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.abc.comp.Student;

@SpringBootApplication
@ImportResource(locations = "in/abc/cfg/applicationContext.xml")
public class BootProj07DependencyInjectionJavaConfigurationApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication
				.run(BootProj07DependencyInjectionJavaConfigurationApplication.class, args);

		System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println();
		System.in.read();
		Student student = context.getBean(Student.class);
		System.out.println(student);
		student.preparation(student.getMaterial().getClass().getName());
		((ConfigurableApplicationContext) context).close();
	}

}
