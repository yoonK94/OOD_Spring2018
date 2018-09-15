package hw3;

public class Dice {
   int sides;
   
   public Dice(int sides) {
      this.sides = sides;
   }
   
   // return true if no 1's are rolled
   public boolean roll(int howmany) {
      for (int i=0; i<howmany; i++) {
         int value = 1 + (int)(Math.random() * sides);
         if (value == 1)
            return false;
      }
      return true;
   }
}
