package spring.alone.test;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		System.out.println("validate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()){
			System.out.println("null");
			errors.reject("name", "trouble");
		}
		
		int studentId = student.getId();
		if(studentId == 0){
			System.out.println("0is no");
			errors.rejectValue("id", "trouble");
		}
	}

	
	
}
