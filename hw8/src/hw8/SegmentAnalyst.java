package hw8;

public class SegmentAnalyst extends AnalystDecorator{
	
	private String segment;
	public SegmentAnalyst(StockAnalyst a) {
		super(a);
		
		try {
			segment = a.getInfo("marketsegment").get(0);
			if (segment.equals("auto"))
				current =  0.2;		
			current = segment.equals("technology")? 0.8: 0;
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
			return a.reasons() + "There is not enough information about the company's segment.\n";
		else {
			if(current == 0.2)
				return a.reasons() + "Auto stocks are a bad risk.\n";
			else if(current == 0.8)
				return a.reasons() + "Tech stocks are a good risk.\n";
			else
				return a.reasons() + "I do not have any opinion about this company's segment.\n";
		}
	}

}
