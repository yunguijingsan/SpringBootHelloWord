package cn.lcf.common;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import cn.lcf.core.exception.ResponseResult;
import cn.lcf.core.spring.CustomFastJsonHttpMessageConverter;
import cn.lcf.ims.controller.ApplicationController;
import cn.lcf.ims.entity.Application;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;

public class TestNormal {
	
	@Test
	public void testMatch(){
		ResponseResult<Application>  result =ResponseResult.createSuccess(new Application());
		System.out.println(CustomFastJsonHttpMessageConverter.serializeToJson(result));
	}
	
	@Test
	public void getParameterType(){
		Class clazz = ApplicationController.class;
		try {
			Method method = clazz.getMethod("addApplication", Application.class);
			Class  returnClass =  method.getReturnType();
			System.out.println(method.getGenericReturnType());
			ParameterizedType type = (ParameterizedType) method.getGenericReturnType();
			System.out.println(type.getActualTypeArguments()[0].toString());
			System.out.println(returnClass);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testThead(){
		for (int i = 0; i < 2; i++) {
			final int k = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					createGroup("I" + k + "I");

				}
			}).start();
		}
	}

	public static void createGroup(final String groupName) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@SuppressWarnings("static-access")
				@Override
				public void run() {
					byte[] lock2 = new byte[0];
					while (true) {
						synchronized (lock2) {
							System.out.println("groupName:" + groupName + " "
									+ Thread.currentThread().getName()
									+ "   get " + groupName);
							try {
								Thread.currentThread().sleep(3000);
							} catch (InterruptedException e) {
							}
						}
					}
				}
			}).start();
		}
	}
}
