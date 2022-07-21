package java_coffee_cup.puzzle.asciiArt;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int L = 0;
		int H = 0;
		String text = null;

		List<String> list = new ArrayList<>();

		// ----------- line 1 ----------------
		L = Integer.parseInt(ss[0]); // width of each letter

		// ----------- line 2 ----------------
		H = Integer.parseInt(ss[1]); // height of each letter

		// ----------- line 3 ----------------
		text = ss[2]; // a text to display

		// ----------- following H lines ----------------
		for (int i = 0; i < H; i++) {
			String line = ss[i + 3];
			list.add(line);
		}

		String ans = Solution.process(list, H, L, text);

		System.err.println("ans = \n" + ans);

		return ans;
	}

}
