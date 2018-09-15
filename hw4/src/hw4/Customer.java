package hw4;

public class Customer {
   private int arrivalTime;
   private int serviceTime;
   private ItemDistribution id;
   
   public Customer(int t, int maxitem, String distT) {
      arrivalTime = t;
      if(distT.equals("u")) {
    	  id = new Uniform();
      }
      else {
    	  id = new Bimodal();
      }
      
      int howmanyItems = id.howmany(maxitem);
      serviceTime = 2*howmanyItems + 10;
   }
   
   public void elapseOneSecond() {
   		serviceTime --;
   }
   
   public boolean isFinished() {
   		return serviceTime == 0;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }
}