package java_coffee_cup.puzzle.unitFraction;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		// ----------- line 1 ----------------
		long n = Long.parseLong(ss[0]);

		String ans = Solution.process(n);

		System.err.println("ans = " + ans);

		return ans;
	}

}
