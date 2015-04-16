package spring_thirdweek.test.logging;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring_thirdweek.test.logging.Student;
import spring_thirdweek.test.logging.Worker;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX_logging.xml");
		
		Student student = ctx.getBean("student",Student.class);
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker",Worker.class);
		worker.getWorkerInfo();
		
		ctx.close();
	}
}
