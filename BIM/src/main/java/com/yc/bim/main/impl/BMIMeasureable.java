package com.yc.bim.main.impl;

import org.springframework.stereotype.Component;

import com.yc.bim.main.Measureable;
import com.yc.spring.entity.Person;
@Component("measureable")
public class BMIMeasureable implements Measureable<Person> {

	@Override
	public double measure(Person person) {
		return person.getWeight()/(person.getHeight()*person.getHeight());
	}

}
