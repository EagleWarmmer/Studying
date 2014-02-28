package com;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class TestRef1 {

	public static void main(String args[]) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {


		Class<?> c = Class.forName("Foo");
		Foo foo = new Foo();
		foo.setMsg("信息");
		foo.setNum(1);
		User user=new User();
		user.setAge(1);
		user.setName("姓名");
		foo.setUser(user);
		
		Foo1 foo1 = new Foo1();
		Class clazz = foo.getClass();
		Class clazz1 = foo1.getClass();
		Method[] md = c.getMethods();// 获取类中所以方法，包括继承的。

		for (Method m : md) {
			String methodName = m.getName();
			if (methodName.startsWith("get") && !methodName.equals("getClass")) {
				String setMethodName = "set" + methodName.substring(3);
				String returnType = m.getReturnType().getName();
				//if(returnType.equals("int")) returnType="java.lang.Integer";
				Class returnClass = Class.forName(returnType);
				Method m3 = clazz.getDeclaredMethod(methodName);
				Method m2 = clazz1.getDeclaredMethod(setMethodName, returnClass);
				Object msg = m3.invoke(foo);

				m2.invoke(foo1, msg);
			}
		}

		System.out.println(foo1.getMsg());
		System.out.println(foo1.getUser().getName());
		System.out.println(foo1.getUser().getAge());
	}
}

class Foo {
	private String msg;
	private Integer num;
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	private User user;

	public Foo() {
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

class Foo1 {
	private String msg;
	private User user;
	private Integer num;
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Foo1() {
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}