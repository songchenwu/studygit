package com.yc.bim.main;

import org.apache.logging.log4j.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yc.bim.main.impl.BIMMeasureFilter;
import com.yc.spring.entity.Person;
@Aspect
@Component//不指定bean 的名字时，默认泪首字母小写
public class FilterAspect {
	
	@Autowired
	private BIMMeasureFilter measureFilter; 
	

	@AfterThrowing(value="execution(* com.yc.bim.main.impl.BMIMeasureable.*(..))",throwing="e")
	public void afterThrowingMethod(JoinPoint joinPoint,Exception e){
		
		Person person=	(Person) joinPoint.getArgs()[0];
		
		boolean wflag=false;
		boolean hflag=false;
		if(person.getHeight() < measureFilter.getMinHeight()||person.getHeight() > measureFilter.getMaxHeight()){
			hflag=true;
		}
		if(person.getWeight() < measureFilter.getMinWeight()||person.getWeight() > measureFilter.getMaxWeight()){
			wflag=true;
		}
		if(wflag && hflag){
			LogManager.getLogger().warn(person + "===>身高和体重都为非正常值");
		}else if(wflag){
			LogManager.getLogger().warn(person + "===>体重都为非正常值");
		}else if(hflag){
			LogManager.getLogger().warn(person + "===>身高非正常值");
		}
	}
}
