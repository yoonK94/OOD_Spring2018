package hw9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductOp implements Polynomial{
	
	private Polynomial left;
	private Polynomial right;
	
	public ProductOp(Polynomial left, Polynomial right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		String result = "(";
		result += left.toString() + " * " + right.toString() + ")"; 
		return result;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof ProductOp) {
			Iterator<Polynomial> i1 = ((ProductOp) obj).childIterator();
			Iterator<Polynomial> i2 = ((ProductOp) obj).childIterator();
			return (left.equals(i1.next()) && right.equals(i1.next()))
					||(right.equals(i2.next())&& left.equals(i2.next()));
		}
		return false;
	}	
	
	public boolean hasNoVariables() {
		return left.hasNoVariables() && right.hasNoVariables();
	}
	
	public int evaluate(Map<String,Integer> m) {
		return left.evaluate(m) * right.evaluate(m);
	}
	
	
	public Polynomial reduce() {
		Polynomial leftR = left.reduce();
		Polynomial rightR = right.reduce();
		
		if(leftR.equals(new Number(0))||rightR.equals(new Number(0)))
			return new Number(0);
		else if(leftR.equals(new Number(1)))
			return rightR;
		else if(rightR.equals(new Number(1)))
			return leftR;
		else if(right instanceof Number && left instanceof Number)
			return new Number(((Number)left).evaluate(null) * ((Number)right).evaluate(null));
		else
			return new ProductOp(leftR, rightR);
	}
	
	public Iterator<Polynomial> childIterator(){
		List<Polynomial> l = new ArrayList<>();
		l.add(left);
		l.add(right);
		return l.iterator();
	}
}
