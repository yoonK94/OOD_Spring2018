package hw8;


public class NameAnalyst extends AnalystDecorator{
	
	public NameAnalyst(StockAnalyst a) {
		super(a);
		String name = "";
		try {
			name = a.getInfo("name").get(0);
			current = Character.toLowerCase(name.charAt(0)) == Character.toLowerCase('A')? 1:0;
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
			return a.reasons() + "There is not enough information about the company's name.\n";
		else {
			if(current == 1)
				return a.reasons() + "I love companies that begin with 'A'.\n";
			else
				return a.reasons() + "I do not have any opinion about this company's name.\n";
		}
	}

}
