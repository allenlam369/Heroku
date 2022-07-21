package java_coffee_cup.puzzle.thomas;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int n;
		int[] arr = null;

		// ----------- line 1 ----------------
		n = Integer.parseInt(ss[0]);
		arr = new int[n];

		// ----------- line 2 ----------------
		String[] ss1 = ss[1].split("\\s");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ss1[i]);
		}
		
		String ans = Solution.process(arr, n);

		System.err.println("ans = " + ans);

		return ans;
	}

}
