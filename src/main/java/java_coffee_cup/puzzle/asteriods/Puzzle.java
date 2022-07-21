package java_coffee_cup.puzzle.asteriods;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int w = 0;
		int h = 0;
		int t1 = 0, t2 = 0, t3 = 0;
		List<String> sList = new ArrayList<>();

		// ----------- line 1 ----------------
		String line1 = ss[0];
		String[] ss1 = line1.split("\\s");
		w = Integer.parseInt(ss1[0]);
		h = Integer.parseInt(ss1[1]);
		t1 = Integer.parseInt(ss1[2]);
		t2 = Integer.parseInt(ss1[3]);
		t3 = Integer.parseInt(ss1[4]);

		// ----------- following h lines ----------------
		for (int i = 0; i < h; i++) {
			String line = ss[i + 1];
			sList.add(line);
		}

		String ans = Solution.process(w, h, t1, t2, t3, sList);

		System.err.println("ans = \n" + ans);

		return ans;
	}

}
