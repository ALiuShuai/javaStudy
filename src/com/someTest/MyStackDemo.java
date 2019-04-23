package com.someTest;


import java.util.LinkedList;

public class MyStackDemo {
	public static void main(String[] args) {
		// 创建集合对象
		MyStack ms = new MyStack();
		// 添加元素
		ms.add("hello");
		ms.add("world");
		ms.add("java");
		while (!ms.isEmpty()) {
			System.out.println(ms.get());
		}
	}
}

class MyStack {
	private LinkedList<Object> link;

	public MyStack() {
		link = new LinkedList<Object>();
	}

	public void add(Object obj) {
		link.addFirst(obj);
	}

	public Object get() {
		// return link.getFirst();
		return link.removeFirst();
	}
 
	public boolean isEmpty() {
		return link.isEmpty();
	}
}
