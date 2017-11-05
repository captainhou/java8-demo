package com.captain.java8.demo3.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.captain.java8.demo2.predicate.Apple;

public class Demo31 {
	public static void main(String[] args) {
		Apple apple1 = new Apple("red", 100);
		Apple apple2 = new Apple("red", 20);
		Apple apple3 = new Apple("green", 100);
		Apple apple4 = new Apple("green", 20);
		List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);
		List<Apple> bigApples = apples.stream()//
				.filter(Apple::isBigApple)//
				.collect(Collectors.toList());
		System.out.println(bigApples);// [(red,100), (green,100)]
		Map<String, List<Apple>> colorApples = apples.stream()//
				.collect(Collectors.groupingBy(Apple::getColor));
		System.out.println(colorApples);// {red=[(red,100)], green=[(green,100)]}
		List<String> colorName = apples.stream()//
				.map(a -> a.getColor())//
				.distinct()//
				.limit(1L)//
				.collect(Collectors.toList());
		System.out.println(colorName);// red

	}

}
