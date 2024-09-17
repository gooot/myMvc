package com.gooot.counter;

public class RaceConditionDemo {
	public static void main(String[] args) {

		Counter counter = new Counter();

		Thread thread1 = new Thread(counter,"Thread-1");
		Thread thread2 = new Thread(counter,"Thread-2");
		Thread thread3 = new Thread(counter,"Thread-3");
		Thread thread4 = new Thread(counter,"Thread-4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
