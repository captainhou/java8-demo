package com.captain.java8.demo1.lambda;

public class Demo1 {
	public static void main(String[] args) {
		fruitStore(new Apple());
		
		fruitStore(new Fruit() {

			public String name() {
				// TODO Auto-generated method stub
				return "this is an orange";
			}
		});
		fruitStore(() -> "this is a pear");
		
		fruitStore(() -> {
			String name = "I'm not fruit";
			return name;
		});

	}

	private static void fruitStore(Fruit fruit) {
		System.out.println(fruit.name());
	}
}
