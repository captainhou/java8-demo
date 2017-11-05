package com.captain.java8.demo6.funreference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import com.captain.java8.demo2.predicate.Apple;

public class Demo6 {
	public static void main(String[] args) {
		Apple apple = new Apple("red", 100);
		Function<Apple, String> showColor1 = (Apple a) -> a.getColor();
		Function<Apple, String> showColor2 = Apple::getColor;
		Consumer<Apple> print = System.out::println;

		System.out.println(showColor1.apply(apple));// red
		System.out.println(showColor2.apply(apple));// red
		print.accept(apple);//(red,100)
		BiFunction<String, Integer, Apple> construct = Apple::new;
		Apple greenApple = construct.apply("green", 100);
		print.accept(greenApple);//(green,100)
	}

}
