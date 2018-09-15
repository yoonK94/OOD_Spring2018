package hw9;

import java.util.*;
import java.util.function.*;

public class HW9Test {
	public static Set<Variable> getVarsExternal(Polynomial p){
		Set<Variable> result = new TreeSet<>();
		getVar(result, p);
		return result;
	}
	
	private static void getVar(Set<Variable> s, Polynomial p) {
		if(p instanceof Variable)
			s.add(new Variable(p.toString()));
		else {
			Iterator<Polynomial> i = p.childIterator();
			while (i.hasNext()) {
				getVar(s, i.next());
			}
		}
			
	}
	
	public static Set<Variable> getVarsInternal(Polynomial p){
		Consumer<Polynomial> c = new PolyReducer();
		p.forEach(c);
		return ((PolyReducer)c).getResult();
		/* 
		PolyReducer c = new PolyReducer();
		p.forEach(c);
		return c.getResult();
		 */
		
	}
	
	private static class PolyReducer implements Consumer<Polynomial>{
		Set<Variable> result = new TreeSet<>();
		public void accept(Polynomial p) {
			if(p instanceof Variable) 
				result.add(new Variable(p.toString()));
		}
		public Set<Variable> getResult(){
			return result;
		}
	}
	
	public static void main(String[] args) {  
		
		Map<String, Integer> m = new HashMap<>();
		m.put("x", 3);
		m.put("y", 4);
		m.put("z", 5);
		
		Polynomial x1 = new Variable("x");
		Polynomial y1 = new Variable("y");
		Polynomial z1 = new Variable("z");
		Polynomial one1 = new Number(1);
		Polynomial three1 = new Number(3);
		Polynomial zero1 = new Number(0);
		Polynomial zero2 = new Number(0);
		Polynomial xTimesOne = new ProductOp(x1, one1);
		Polynomial p11 = new PlusOp(xTimesOne, three1);
		Polynomial yPlusZero = new PlusOp(y1, zero1);
		Polynomial zTimesZero = new ProductOp(z1, zero2);
		Polynomial p12 = new PlusOp(yPlusZero, zTimesZero);
		Polynomial p13 = new ProductOp(p11, p12);
		
		String s1 = p13.toString();
		System.out.println("The expression is " + s1);
		System.out.println("It evaluates to " + p13.evaluate(m));
		System.out.println("It reduces to " + p13.reduce());
		System.out.println("Using external iteration, its variables are " + getVarsExternal(p13).toString());
		System.out.println("Using internal iteration, its variables are " + getVarsInternal(p13).toString());
		
		System.out.println();
		
		Polynomial x2 = new Variable("x");
		Polynomial y2 = new Variable("y");
		Polynomial z2 = new Variable("z");
		Polynomial x3 = new Variable("x");
		Polynomial z3 = new Variable("z");
		Polynomial x4 = new Variable("x");
		Polynomial three2 = new Number(3);
		Polynomial xPlusThree2 = new PlusOp(x2, three2);
		Polynomial p21 = new ProductOp(xPlusThree2, y2);
		Polynomial zPlusX = new PlusOp(z2, x3);
		Polynomial xPlusZ = new PlusOp(x4, z3);
		Polynomial p22 = new MinusOp(zPlusX, xPlusZ);
		Polynomial p23 = new PlusOp(p21, p22);
		
		String s2 = p23.toString();
		System.out.println("The expression is " + s2);
		System.out.println("It evaluates to " + p23.evaluate(m));
		System.out.println("It reduces to " + p23.reduce());
		System.out.println("Using external iteration, its variables are " + getVarsExternal(p23).toString());
		System.out.println("Using internal iteration, its variables are " + getVarsInternal(p23).toString());
		
	}
}
