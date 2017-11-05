package com.captain.java8.demo12.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class Demo12 {
	private static ExecutorService executor = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		Future<String> future = executor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "after 2 seconds, ok";
			}
		});
		String result = future.get();//blocking
		System.out.println(result);
		
	}

}
