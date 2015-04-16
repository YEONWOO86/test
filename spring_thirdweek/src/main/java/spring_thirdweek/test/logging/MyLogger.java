package spring_thirdweek.test.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;

@Aspect
public class MyLogger {

	private Logger log = Logger.getLogger(getClass());
	
	@Before("within(spring_thirdweek.test.logging.*)")
	public void s_log(JoinPoint point){
		log.info(point.getSignature().getName() + " start ...");
	}
	
	
	@After("within(spring_thirdweek.test.logging.*)")
	public void log(JoinPoint point){
		log.info(point.getSignature().getName() + " called...");
	}
	
}
