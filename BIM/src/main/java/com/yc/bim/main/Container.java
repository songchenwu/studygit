package com.yc.bim.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yc.bim.exception.BIMExcption;

@Component("container")
public class Container <T>{
	@Autowired
	private Measureable<T> measureable;
	@Autowired
	private MeasureFilter<T> measureFilter;

	private List<T> objs = new ArrayList<T>();
	private Object maxObj;
	private Object minObj;
	private double total;


	public void add(T obj) {
		// 1.先过滤,
		try {
			measureFilter.doFilter(obj);
		} catch (BIMExcption e) {
			return;
		}

		// 2.再测量
		double currentValue = measureable.measure(obj);

		// 3.设最大值和最小值
		if (maxObj == null && minObj == null) {
			maxObj =obj;
			minObj = obj;
		} else if (currentValue > measureable.measure(obj)) {
			maxObj = obj;
		} else if (currentValue < measureable.measure(obj)) {
			minObj = obj;
		}
		// 4.计算总量
		total += currentValue;
		// 5.添加到测量数据集中
		objs.add(obj);
	}

	public List<T> getObjs() {
		return objs;
	}

	public Object getMaxObj() {
		return maxObj;
	}

	public Object getMinObj() {
		return minObj;
	}

	public double getTotal() {
		return total;
	}

	//取平均量
	public double getAvg() {
		if (objs.size() == 0) {
			return 0;
		} else {
			return total / objs.size();
		}
	}

}
