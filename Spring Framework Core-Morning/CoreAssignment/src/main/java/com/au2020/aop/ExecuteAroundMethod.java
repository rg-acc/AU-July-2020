package com.au2020.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ExecuteAroundMethod {
 
    @Around("allArea()")
    public Object shapeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
    	
    	//printing the join point
    	System.out.println(proceedingJoinPoint.toShortString());
    	System.out.println("Before invoking area() method");
    	Object value = null;
		try {
			
			value = proceedingJoinPoint.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking area() method. Area=" + value);
		return value;
	}
    
    @Pointcut("execution(* area())")
	public void allArea(){} 
    
}