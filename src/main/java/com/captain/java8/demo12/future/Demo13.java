package com.captain.java8.demo12.future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo13 {
	private static Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) throws InterruptedException {
		List<String> list = Arrays.asList("banana1", "apple2", "orange3", "banana4", "apple5", "orange6", "banana7", "apple8",
				"orange9", "banana10", "apple11", "orange12");
		System.out.println("list.size=" + list.size());
		sequence1(list);
		System.out.println("----");
		sequence2(list);
		System.out.println("----");
		parallel(list);
	}

	private static void sequence1(List<String> list) throws InterruptedException {
		long start = System.nanoTime();
		List<CompletableFuture<String>> results = list.stream()//
				.map(name -> CompletableFuture.supplyAsync(() -> "I like " + getName(name)))
				.collect(Collectors.toList());
		long phase1 = System.nanoTime();
		results.stream().map(CompletableFuture::join).forEach(s -> System.err.print(s+","));
		long phase2 = System.nanoTime();
		TimeUnit.SECONDS.sleep(1);// io blocking
		System.out.println((phase1 - start) / 1_000_000);
		System.out.println((phase2 - phase1) / 1_000_000);
	}

	private static void sequence2(List<String> list) throws InterruptedException {
		long start = System.nanoTime();
		list.stream()//
				.map(name -> CompletableFuture.supplyAsync(() -> "I like " + getName(name)))
				.map(CompletableFuture::join).forEach(s -> System.err.print(s+","));
		long phase1 = System.nanoTime();
		TimeUnit.SECONDS.sleep(1);// io blocking
		System.out.println((phase1 - start) / 1_000_000);//12000+
	}
	private static void parallel(List<String> list) throws InterruptedException {
		long start = System.nanoTime();
		list.stream().parallel()//
		.map(name -> CompletableFuture.supplyAsync(() -> "I like " + getName(name)))
		.map(CompletableFuture::join).forEach(s -> System.err.print(s+","));
		long phase1 = System.nanoTime();
		TimeUnit.SECONDS.sleep(1);// io blocking
		System.out.println((phase1 - start) / 1_000_000);//12000+
	}

	private static String getName(String name) {
		long s = random.nextLong() % 2000;
		s = s > 0 ? s : (-1) * s;
		try {
			// System.out.println("sleep," + s);
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

}
