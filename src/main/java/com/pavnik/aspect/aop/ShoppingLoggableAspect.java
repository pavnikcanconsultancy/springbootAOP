package com.pavnik.aspect.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect @Configuration
public class ShoppingLoggableAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Around(
			value = 
			"@annotation(com.pavnik.aspect.aop.ShoppingLoggable)")
	public void aroundAspect(ProceedingJoinPoint joinPoint ) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		LOGGER.info("Time Taken for execution {} is {}", joinPoint.getSignature(), timeTaken);	
	}

}
