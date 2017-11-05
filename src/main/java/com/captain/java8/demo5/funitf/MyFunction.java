package com.captain.java8.demo5.funitf;

import java.util.function.Function;

import com.captain.java8.demo2.predicate.Apple;

public class MyFunction implements Function<Apple, String> {

	@Override
	public String apply(Apple t) {
		return t.getColor();
	}

}
