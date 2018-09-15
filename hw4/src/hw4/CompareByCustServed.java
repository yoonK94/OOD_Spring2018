package hw4;

import java.util.Comparator;

public class CompareByCustServed implements Comparator<CashRegister>{
	public int compare(CashRegister r1, CashRegister r2) {
		return r2.getNumServed() - r1.getNumServed();
	}
}
