package hw6;

import java.util.*;
import java.util.function.*;

public class HW6Test {
   public static void main(String[] args) {
      Comparator<String> comp = (s1,s2)->s1.compareTo(s2);
      
      Collection<String> c1 = new TreeSet<>(comp);
      c1.addAll(Arrays.asList("a", "c", "d", "e", "g", "h", "j"));
      Collection<String> c2 = new TreeSet<>(comp);
      c2.addAll(Arrays.asList("b", "f", "m", "n", "p"));
      
      Collection<String> c3 = new MergedCollection<>(c1, c2, comp);
      /*
      for(String s : c3) 
         System.out.print(s + " ");
      */
      c3.forEach(e -> System.out.print(e + " "));
      System.out.println();
      
      Comparator<Integer> comp2 = (i1, i2) -> i2 - i1;
      
      Collection<Integer> c4 = new TreeSet<>(comp2);
      for(int i = 0; i<10; i++)
    	  c4.add((int)Math.floor(Math.random()* 101));
      Collection<Integer> c5 = new TreeSet<>(comp2);
      for(int i = 0; i<10; i++)
    	  c5.add((int)Math.floor(Math.random()* 101));
      
      Collection<Integer> c6 = new MergedCollection<>(c4, c5, comp2);
      
      for(int i : c6)
    	  System.out.print(i + " ");
      System.out.println();
      
      c6.forEach(e -> System.out.print(e + " "));
      System.out.println();
      
      Predicate<Integer> pred = val -> (val % 2) == 0;
      int x = howMany(c6, pred);
      System.out.println("There are " + x + " even values.");
      
      Reducer<Integer, Integer> r = new CountReducer<>(pred);
      c6.forEach(r);
      System.out.println("There are " + r.result() + " even values.");
   }
   
   public static <T> int howMany(Iterable<T> c, Predicate<T> pred) {
	   int count = 0;
	   for(T i : c)
		   if(pred.test(i))	count++;
	   return count;
   }
}
