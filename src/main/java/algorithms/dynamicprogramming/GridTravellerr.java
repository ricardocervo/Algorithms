package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class GridTravellerr {

	public long gridTraveller(int m, int n) {
		return gridTraveller(m, n, new HashMap<>());
	}
	
	public long gridTraveller(int m, int n, Map<String, Long> memo) {
		if (m == 1 && n == 1) return 1;
		if (m == 0 || n == 0) return 0;

		String key = m + "," + n;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		memo.put(key, gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo));
		
		return memo.get(key);
	}

	public static void main(String[] args) {
		GridTravellerr program = new GridTravellerr();
		System.out.println(program.gridTraveller(1, 1));
		System.out.println(program.gridTraveller(2, 3));
		System.out.println(program.gridTraveller(3, 2));
		System.out.println(program.gridTraveller(3, 3));
		System.out.println(program.gridTraveller(18, 18));
		System.out.println(program.gridTraveller(50, 50));
	}

}
