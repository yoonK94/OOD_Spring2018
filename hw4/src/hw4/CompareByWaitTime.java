package hw4;

import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister>{
	public int compare(CashRegister r1, CashRegister r2) {
		return r1.avgWaitTime() - r2.avgWaitTime();
	}
}
