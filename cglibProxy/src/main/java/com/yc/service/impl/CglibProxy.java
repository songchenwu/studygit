package com.yc.service.impl;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib���������ʵ�ִ���ģ�����ԭ���Ƕ�ָ����Ŀ��������һ�����࣬
 * ���������з���ʵ����ǿ������Ϊ���õ��Ǽ̳У����Բ��ܶ�final���ε�����д��� 
 * @author hy
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// �ص�����
		enhancer.setCallback(this);
		// �����������
		return enhancer.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("���￪ʼ");
		proxy.invokeSuper(obj, args);
		System.out.println("�������");
		return null;
	}

	

}
