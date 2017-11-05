package com.captain.java8.demo3.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.captain.java8.demo2.predicate.Apple;

public class Demo32 {
	public static void main(String[] args) {
		Apple apple1 = new Apple("red", 100);
		Apple apple2 = new Apple("red", 90);
		Apple apple3 = new Apple("red", 80);
		Apple apple4 = new Apple("red", 70);
		List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);
		System.out.println("排序前：" + apples);
		List<Apple> sortedApples1 = apples.stream()//
				.sorted(new Comparator<Apple>() {
					@Override
					public int compare(Apple o1, Apple o2) {
						// TODO Auto-generated method stub
						return o1.getSize() - o2.getSize();
					}
				}).collect(Collectors.toCollection(() -> new ArrayList<>()));

		System.out.println("排序后：" + sortedApples1);
		List<Apple> ascApples2 = apples.stream()//
				.sorted((a1, a2) -> a1.getSize() - a2.getSize())//
				.collect(Collectors.toList());
		System.out.println("排序后：" + ascApples2);
		List<Apple> descApples3 = ascApples2.stream()//
				.sorted(Comparator.comparing(Apple::getSize).reversed())//
				.collect(Collectors.toList());
		System.out.println("逆序：" + descApples3);
		// demo
		// Runnable r = () -> System.out.println("Hello world");
		long count = descApples3.stream().count();// 4
		descApples3.stream().skip(2).limit(1).forEach(System.out::println);
		// (red,100)---
		// (red,90)---
		// (red,80)
		// (red,70)----
		//default interface method
		descApples3.sort((a1, a2) -> a1.getSize() - a2.getSize());

	}

}
