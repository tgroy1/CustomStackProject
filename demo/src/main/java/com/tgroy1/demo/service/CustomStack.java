package com.tgroy1.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomStack {
	
	private int[] arr;
	private int top;
	private int capacity;

	public CustomStack(@Value("${stack.maxsize}") String maxSize) {
		int size = Integer.valueOf(maxSize);
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	public void push(int x) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is full");
		}
		arr[++top] = x;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		return arr[top--];
	}

	public int get() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		return arr[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == capacity;
	}

}
