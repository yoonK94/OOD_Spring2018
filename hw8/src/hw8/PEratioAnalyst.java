package hw8;

public class PEratioAnalyst extends AnalystDecorator{

	private double PEratio = 0;

	public PEratioAnalyst(StockAnalyst a) {
		super(a);
		
		try {
			int price = Integer.parseInt(a.getInfo("shareprice").get(0));
			double earning = Double.parseDouble(a.getInfo("earnings").get(0));
			PEratio = price/earning;
			current = 1 - (PEratio / 24);
		} 
	    catch (NullPointerException e) {
	    	nonInfo = true;
	    }
		
	}
	
	public double confidenceLevel() {
		
		return current == 0? a.confidenceLevel() : (current + a.confidenceLevel())/2;
	}
	
	public String reasons() {
		if(nonInfo)
			return a.reasons() + "There is not enough information about PEratio.\n";
		else {
			if(current < 0.5)
				return a.reasons() + "The PE ratio is " + PEratio + ", which is bad.\n";
			else
				return a.reasons() + "The PE ratio is " + PEratio + ", which is good.\n";
		}
	}
}
