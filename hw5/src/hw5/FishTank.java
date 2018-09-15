package hw5;

import java.util.*;
import javafx.scene.layout.Pane;

public class FishTank {
   List<Fish> fishes = new ArrayList<>();
   Pane p;
   boolean suspended = false;
   private FishFactory[] factory;

   public FishTank(Pane p, FishFactory[] factory) {
      this.p = p;
      this.factory = factory;
   }
   public void addFish(int fishtype) {
      Fish f = factory[fishtype].create();
      
      fishes.add(f);
      p.getChildren().add(f.getView());
   }

   public void startAnimation() {
      suspended = false;
   }

   public void stopAnimation() {
      suspended = true;
   }

   public void move(double height, double width) {
      if (!suspended) {
         for (Fish f : fishes) 
            f.move(height, width);
      }
   }
}
