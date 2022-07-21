package java_coffee_cup.puzzle.remainder;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int N = 0;
		List<String> list = new ArrayList<>();

		// ----------- line 1 ----------------
		N = Integer.parseInt(ss[0]); // width of each letter

		// ----------- following N lines ----------------
		for (int i = 0; i < N; i++) {
			String line = ss[i + 1];
			list.add(line);
		}

		String ans = Solution.process(list, N);

		System.err.println("ans = \n" + ans);

		return ans + "\n";
	}

}
