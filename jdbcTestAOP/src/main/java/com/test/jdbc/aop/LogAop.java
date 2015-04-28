package com.test.jdbc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LogAop{
	
	@Pointcut("execution(* com.test.jdbc.dao.BoardDaoImpl.*(..))")
	public void aop_Test(){	}
	
/*	@Before("aop_Test()")
	public void before(JoinPoint jpo){
		System.out.println("���Ͷ�"+ jpo.toString());
	}*/
	
	@Around("aop_Test()")
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		String singnatureStr = joinpoint.getSignature().toShortString();
		System.out.println( singnatureStr + " is start.");
		try{
			Object obj = joinpoint.proceed();
			return obj;
		}finally{
			System.out.println( singnatureStr + " is finished.");
		}
	}
}
