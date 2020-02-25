/**
 * 
 */
package com.pavnik.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.pavnik.aspectexception.ItemNotFoundException;

/**
 * @author pavni
 *
 */
@Aspect @Configuration
public class ShoppingLogAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Before(
			value = 
			"execution(* com.pavnik.aspect.controller.ShoppingCartController.*(..))")
	public void beforeAspect(JoinPoint joinPoint )
	{
		LOGGER.debug("Before execution of {}", joinPoint.getSignature());
	}

	@After(
			value = 
			"execution(* com.pavnik.aspect.controller.ShoppingCartController.*(..))")
	public void afterAspect(JoinPoint joinPoint )
	{
		LOGGER.debug("After execution of {}", joinPoint.getSignature());
	}
	@AfterReturning(
			value = 
					"execution(* com.pavnik.aspect.controller.ShoppingCartController.*(..))", returning = "value")
	public void afterReturningAspect(JoinPoint joinPoint, Object value )
	{
		LOGGER.debug("After returning of {} with return value {}", joinPoint.getSignature(), value);
	}
	@AfterThrowing (pointcut = "execution(* com.pavnik.aspect.controller.ShoppingCartController.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(ItemNotFoundException ex) throws Throwable  
	{
		LOGGER.error("Exception Occured, No Item Found..!");
	}	
}
