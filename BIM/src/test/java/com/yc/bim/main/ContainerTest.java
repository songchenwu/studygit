package com.yc.bim.main;


import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.spring.entity.Person;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ContainerTest {
	@Autowired
	private Container<Person>  container;
	
	@Autowired
	private FilterAspect filterAspect;
	
	@Test
	public void testAdd() {
		Random r=new Random();
		for (int i=0;i<10;i++) {
			Person p=new Person();
			p.setName("黄"+i);
			p.setHeight(r.nextInt(120));
			p.setWeight(r.nextInt(250));
			container.add(p);
		}
		LogManager.getLogger().debug("测量的对象===>"+container.getObjs());
		LogManager.getLogger().debug("测量的最大对象===>"+container.getMaxObj());
		LogManager.getLogger().debug("测量的最小对象===>"+container.getMinObj());
		LogManager.getLogger().debug("测量的总量===>"+container.getTotal());
		LogManager.getLogger().debug("测量的平均量===>"+container.getAvg());
	}

}
