package com.captain.java8.demo10.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Demo10 {
	public static void main(String[] args) {
		long n = 1000000L;
		long start = System.nanoTime();
		parallelRangedSum(n);
		long end1 = System.nanoTime();
		sequentialRangedSum(n);
		long end2 = System.nanoTime();
		System.out.println(end1 - start);// 61,408,992
		System.out.println(end2 - end1); // /5,089,093
		long[] arrayOfLong = new long[20000];

		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		long start2 = System.nanoTime();
		Arrays.parallelSort(arrayOfLong);
		long end3 = System.nanoTime();
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println(end3 - start2);// 4,351,750
		old(20000);                       //11,088,494

	}

	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static long sequentialRangedSum(long n) {
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}

	public static void old(int n) {
		List<Integer> list = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			list.add(ThreadLocalRandom.current().nextInt(1000000));
		}
		long start2 = System.nanoTime();
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		long end3 = System.nanoTime();
		System.out.println();
		System.out.println(end3 - start2);// 4,351,750
	}

}
