package com.captain.java8.demo5.funitf;

import java.util.function.Supplier;

import com.captain.java8.demo2.predicate.Apple;

public class MySupplier implements Supplier<Apple> {

	@Override
	public Apple get() {
		return new Apple("red", 100);
	}

}
