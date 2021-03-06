package com.jwt.demo.thread_examples;

public class NoLockIssue {

	static int count = 0;

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				int n = 100000;
				while (n > 0) {
					count++;
					System.out.println(Thread.currentThread().getName().concat(": ").concat(String.valueOf(count)));
					n--;
				}
			}
		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);
		Thread t5 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try {
			Thread.sleep(20000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);

	}
}
