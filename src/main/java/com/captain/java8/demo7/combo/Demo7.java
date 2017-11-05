package com.captain.java8.demo7.combo;

import java.util.function.Function;

public class Demo7 {
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h1 = f.andThen(g); // h1(x) = g(f(x));
		Function<Integer, Integer> h2 = f.compose(g);// h2(x) = f(g(x));
		System.out.println(h1.apply(2));// 6
		System.out.println(h2.apply(2));// 5
	}

}
