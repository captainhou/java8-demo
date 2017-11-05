package com.captain.java8.demo10.parallel;

import java.util.stream.LongStream;

public class Demo10 {
	public static void main(String[] args) {
		long n = 1000000L;
		long start = System.nanoTime();
		parallelRangedSum(n);
		long end1 = System.nanoTime();
		sequentialRangedSum(n);
		long end2 = System.nanoTime();
		System.out.println(end1 - start);// 61408992
		System.out.println(end2 - end1); // /5089093

	}

	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static long sequentialRangedSum(long n) {
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}

}
