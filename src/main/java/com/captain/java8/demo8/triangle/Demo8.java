package com.captain.java8.demo8.triangle;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo8 {
	public static void main(String[] args) {
		Stream<double[]> tri = IntStream.rangeClosed(1, 100).boxed()// [1,100]
				.flatMap(a -> IntStream.rangeClosed(a, 100)//
						.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }))//
				.filter(t -> t[2] % 1 == 0);
		tri.forEach(d -> System.out.println(d[0] + "," + d[1] + "," + d[2]));
	}

}
