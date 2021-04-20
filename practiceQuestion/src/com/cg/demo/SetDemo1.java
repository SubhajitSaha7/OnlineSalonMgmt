package com.cg.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		System.out.println(set.add("ram"));
		set.add("tom");
		set.add("anand");
		set.add("sam");
		set.add("ajit");
		System.out.println(set.add("tom"));
		set.forEach(System.out :: println);
	}
}