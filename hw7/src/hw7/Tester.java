package hw7;

import java.util.*;

public class Tester {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		Collection<String> c2 = new ArrayList<>();
		c.add("1");
		c.add("2");
		c.add("3");
		/*c.add("4");
		c.add("5");
		c.add("6");
//		c.add("10");
		c.add("7");
		c.add("8");
		c.add("9");
		*/
		/*
		for(int i = 0; i< 10; i += 2)
			c.add(Integer.toString(i));
		for(int i = 1; i< 10; i += 2)
			c2.add(Integer.toString(i));
		*/
		System.out.println(c.toString());
		c = new SortedCollection<String>(c, (s1,s2)->s2.compareTo(s1));
		Iterator<String> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.print(" " + iter.next());
		}
		
	}
}
