package hw3;

public class TimidPlayer extends Player {
   public TimidPlayer(String name) {
      super(name);
   }

   public boolean takeThePot(Participants p, int pot) {
      return true;
   }
   
   public String getType() {
		return "Timid Player";
   }
}
