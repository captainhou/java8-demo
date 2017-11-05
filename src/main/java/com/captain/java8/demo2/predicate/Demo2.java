package com.captain.java8.demo2.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo2 {
	public static void main(String[] args) {
		Apple apple1 = new Apple("red", 80);
		Apple apple2 = new Apple("green", 120);
		List<Apple> apples = Arrays.asList(apple1, apple2);
		System.out.println(filterApple(apples, (Apple a) -> a.checkColor("red")));
		System.out.println(filterApple(apples, (a) -> a.checkColor("yellow")));
		System.out.println(filterApple(apples, (a) -> a.checkColor("green") && a.isBigApple()));
		System.out.println(filterApple(apples, (a) -> a.getSize() > 50));
		System.out.println(filterApple(apples, Apple::isBigApple));

	}

	private static List<Apple> filterApple(List<Apple> list, Predicate<Apple> standards) {
		List<Apple> result = new ArrayList<>();
		for (Apple a : list) {
			if (standards.test(a)) {
				result.add(a);
			}
		}
		return result;
	}

}
