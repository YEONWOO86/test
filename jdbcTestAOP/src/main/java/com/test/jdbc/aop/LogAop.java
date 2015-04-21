package com.test.jdbc.aop;

import org.aspectj.lang.ProceedingJoinPoint;


public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		String singnatureStr = joinpoint.getSignature().toShortString();
		System.out.println( singnatureStr + " is start.");
//		System.out.println("start");
		try{
//			System.out.println("2");
			Object obj = joinpoint.proceed();
			return obj;
		}finally{
			System.out.println( singnatureStr + " is finished.");
			System.out.println("end");
		}
	}
}
