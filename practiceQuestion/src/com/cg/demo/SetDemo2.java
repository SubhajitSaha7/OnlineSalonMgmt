package com.cg.demo;

import java.util.HashSet;
import java.util.Set;

import com.cg.beans.Emp;

public class SetDemo2 {
	public static void main(String[] args) {
		Emp e1 = new Emp(1001,20000,"ram");
		Emp e2 = new Emp(1003,50000,"tom");
		Emp e3 = new Emp(1007,70000,"sam");
		Emp e4 = new Emp(1002,10000,"ajay");
		Emp e5 = new Emp(1004,40000,"ajit");
		Emp e6 = new Emp(1001,20000,"ram");
		Emp e7 = e2;
		Set<Emp> set = new HashSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		System.out.println(set.add(e6));
		System.out.println(set.add(e7));
		System.out.println(set.size());
		set.forEach(System.out :: println);
	}

}