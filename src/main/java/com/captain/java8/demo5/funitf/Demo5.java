package com.captain.java8.demo5.funitf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

import com.captain.java8.demo2.predicate.Apple;

public class Demo5 {
	public static void main(String[] args) {
		Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getSize() - a2.getSize();
		ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getSize() - a2.getSize();
		BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getSize() - a2.getSize();
		Apple apple1 = new Apple("red", 100);
		Apple apple2 = new Apple("red", 90);
		Apple apple3 = new Apple("red", 80);
		Apple apple4 = new Apple("red", 70);
		List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);
		apples.sort(c1);// c1,c2,c3
		System.out.println(apples);
	}
}
