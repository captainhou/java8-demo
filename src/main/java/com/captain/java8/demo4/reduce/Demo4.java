package com.captain.java8.demo4.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo4 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);// 15
		int parallel = numbers.parallelStream().reduce(1, (a, b) -> a + b);
		System.out.println(parallel);// 20

		Optional<Integer> sum2 = numbers.stream().reduce((a, b) -> a + b);
		System.out.println(sum2);// Optional[15]
		
		Integer max = numbers.stream().reduce(Integer::max).get();
		System.out.println(max);//5
		List<Integer> emptyList = new ArrayList<>();
		//Integer nullMax = emptyList.stream().reduce(Integer::max).get();//java.util.NoSuchElementException
		Integer min = numbers.stream().reduce((x,y) ->x<y?x:y).get();//1
	}

}
