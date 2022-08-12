package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoverDebts {

	class Debt {
	    double value;
	    int interest;
	    
	    Debt(int value, int interest) {
	        this.value = value;
	        this.interest = interest;
	    }

	}

	double solution(int s, int[] debts, int[] interests) {
	    
	    List<Debt> list = new ArrayList<>();
	    for (int i=0; i < debts.length; i++) {
	        list.add(new Debt(debts[i], interests[i]));
	    }
	    Comparator<Debt> comp = (d1, d2) -> Integer.compare(d2.interest, d1.interest);
	    Collections.sort(list, comp);                            
	        
	    double money = ((double) s * 0.1);                        
	    double moneySpent = 0;
	    boolean allPaid = false;

	    int indFirstNonPaid = 0;
	    while (!allPaid) {
	        money = (int) ((double) s * 0.1);                        
	        allPaid = false;
	        for (int i = indFirstNonPaid; i < list.size(); i++) {
	            Debt debt = list.get(i);
	            if (money >= debt.value) {
	                moneySpent += debt.value;
	                money -= debt.value;
	                debt.value = 0; 
	                if (i == list.size() - 1) {
	                    allPaid = true;
	                    break;
	                }
	                               
	            } else {
	                debt.value -= money;
	                moneySpent += money;
	                money = 0;
	                indFirstNonPaid = i;
	                allPaid = false;
	                break;
	            }
	        }
	    
	        if (!allPaid) {
	            for (int i = indFirstNonPaid; i<list.size(); i++) {
	            	Debt debt = list.get(i);
	            	double vDebt = debt.value;
	            	int vInterest = debt.interest;
	                debt.value = ((double) debt.value + (double) debt.value * ((double) debt.interest / 100D));
	            }                               
	        }                    
	    
	    }
	    
	    return moneySpent;
	}

	void initTests() {
		int salary = 50;
		int[] debts = {2, 2, 5};
		int[] interests = {200, 100, 150};
		double result = solution(salary, debts, interests);
		System.out.println(result);

		salary = 40;
		debts = new int[]{2, 2, 5};
		interests = new int[]{75, 25, 25};
		result = solution(salary, debts, interests);
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		new CoverDebts().initTests();
	}
}
