package com.captain.java8.demo3.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo33 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList(//
				"Row Row Row your boat,",//
				"Gently down the stream.",//
				"Merrily Merrily Merrily Merrily,",//
				"Life is but a dream.");

		list.stream().map(s -> s.split(" ")).peek((s) -> {
			System.out.println("words in line:" + Arrays.asList(s));

		}).flatMap(Arrays::stream)//
		;
	}
}
