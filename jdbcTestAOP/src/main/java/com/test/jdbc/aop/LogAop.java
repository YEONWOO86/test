package com.test.jdbc.aop;

import org.aspectj.lang.ProceedingJoinPoint;


public class LogAop {
	
/*	@Pointcut("execution(public * com.test.jdbc.dao.BoardDaoImpl.*(..))")
	private void profileTarget(){
		
	}*/
	
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		String singnatureStr = joinpoint.getSignature().toShortString();
		System.out.println( singnatureStr + " is start.");
		try{
			Object obj = joinpoint.proceed();
			return obj;
		}finally{
			System.out.println( singnatureStr + " is finished.");
			System.out.println("end");
		}
	}
}
