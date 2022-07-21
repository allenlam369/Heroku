package java_coffee_cup.puzzle.lightBulbs;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		String st = ss[0];
		String ed = ss[1];


		String ans = Solution.process(st, ed);

		System.err.println("ans = " + ans);

		return ans;
	}

}
