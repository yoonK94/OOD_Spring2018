package hw7;

import java.util.*;
import java.util.function.Predicate;
import java.io.*;

public class HW7Test {
   public static void main(String[] args) throws IOException {
      Collection<String> dict = readFromFile("dictionary.txt");
      Collection<String> reversedict = reverse(dict);
      
      // predicate p1 denotes words longer than 20 characters
      printWords(reversedict, w -> w.length() > 20);

      System.out.println();

      // predicate p2 denotes words beginning with "chori".
      printWords(reversedict, w -> w.startsWith("chori"));
   }

   public static Collection<String> readFromFile(String fName) throws FileNotFoundException {

	    File file = new File(fName);
	    Scanner sc = new Scanner(file);
	    Collection<String> c = new ArrayList<>();
	    
	    while (sc.hasNextLine())     
	    	c.add(sc.nextLine());
	    sc.close(); 
	    
	    return c;
	 }
   
   public static Collection<String> reverse(Collection<String> c){
	   return new SortedCollection<String>(c, (s1,s2) -> s2.toLowerCase().compareTo(s1.toLowerCase()));
   }
   
   public static void printWords(Collection<String> c, Predicate<String> pred) {
	   c.stream()
	    .filter(pred)
	    .forEach(s-> System.out.println(s));
   }
}
