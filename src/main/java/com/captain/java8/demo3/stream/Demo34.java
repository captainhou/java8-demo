package com.captain.java8.demo3.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.captain.java8.demo2.predicate.Apple;

public class Demo34 {
	public static void main(String[] args) {
		Apple apple1 = new Apple("red", 100);
		Apple apple2 = new Apple("red", 20);
		Apple apple3 = new Apple("green", 100);
		Apple apple4 = new Apple("green", 20);
		List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);

		boolean isRed = apples.stream().anyMatch(a -> "red".equals(a.getColor()));// true
		boolean allRed = apples.stream().allMatch(a -> "red".equals(a.getColor()));// false
		boolean noneRed = apples.stream().allMatch(a -> "red".equals(a.getColor()));// false

		Optional<Apple> red100 = apples.stream().filter(a -> "red".equals(a.getColor())).filter(a -> a.getSize() >= 100)
				.findAny();
		Optional<Apple> redApple = apples.stream().filter(a -> "red".equals(a.getColor())).findAny();//
		System.out.println(redApple);
		apples.stream().filter(a -> "red".equals(a.getColor())).findFirst().ifPresent(a->System.out.println(a));
		Optional<Apple> yellowApple = apples.stream().filter(a -> "yellow".equals(a.getColor())).findAny();//
		System.out.println(yellowApple);
	}

}
