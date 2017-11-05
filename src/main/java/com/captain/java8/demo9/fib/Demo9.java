package com.captain.java8.demo9.fib;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo9 {
	public static void main(String[] args) {
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })//
				.limit(10)//
				.forEach(t -> System.out.println(t[0]));
		IntSupplier fib = new IntSupplier() {
			private int f1=0;
			private int f2=1;
			@Override
			public int getAsInt() {
				int old = this.f1;
				this.f1 = f1+f2;
				this.f2 = old;
				return old;
			}
		};
		IntStream.generate(fib).limit(10).forEach(t->System.out.print(t+","));
	}

}
