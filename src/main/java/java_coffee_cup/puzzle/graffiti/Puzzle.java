package java_coffee_cup.puzzle.graffiti;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int L = 0;
		int N = 0;
		List<String> list = new ArrayList<>();

		// ----------- line 1 ----------------
		L = Integer.parseInt(ss[0]);

		// ----------- line 2 ----------------
		N = Integer.parseInt(ss[1]);

		// ----------- following N lines ----------------
		for (int i=0; i<N; i++) {
			String line = ss[i+2];
			list.add(line);
		}

		String ans = Solution.process(list, L);

		System.err.println("ans = " + ans);

		return ans;
	}

}
