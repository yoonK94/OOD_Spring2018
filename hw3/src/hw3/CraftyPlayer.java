package hw3;

public class CraftyPlayer extends Player {

   public CraftyPlayer(String name) {
      super(name);
   }

   public boolean takeThePot(Participants p, int pot) {
      int maxchips = -1;
      for (Player player : p.allPlayers()) {
         int chips = player.chipsWon();
         if (chips > maxchips)
            maxchips = chips;
      }
      // cash out if I will have more chips than anyone else
      return (chipsWon() + pot > maxchips);
   }       
   
   public String getType() {
		return "Crafty Player";
   }
}

