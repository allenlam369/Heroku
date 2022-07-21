package java_coffee_cup.puzzle.rectanglePartition;

public class Puzzle {

	public static String solve(String input) {
		String[] ss = input.split("\\n");
		for (String s : ss) {
			System.err.println(s);
		}

		int w, h, countX, countY;
		int[] arr1 = null;
		int[] arr2 = null;

		// ----------- line 1 ----------------
		String[] ss1 = ss[0].split("\\s");

		w = Integer.parseInt(ss1[0]);
		h = Integer.parseInt(ss1[1]);
		countX = Integer.parseInt(ss1[2]);
		countY = Integer.parseInt(ss1[3]);

		arr1 = new int[countX + 2];
		arr2 = new int[countY + 2];
		arr1[countX + 1] = w;
		arr2[countY + 1] = h;

		// ----------- line 2 ----------------
		String[] ss2 = ss[1].split("\\s");
		for (int i = 1; i <= countX; i++) {
			arr1[i] = Integer.parseInt(ss2[i - 1]);
		}

		// ----------- line 3 ----------------
		String[] ss3 = ss[2].split("\\s");
		for (int i = 1; i <= countY; i++) {
			arr2[i] = Integer.parseInt(ss3[i - 1]);
		}

		String ans = RectanglePartition.process(w, h, arr1, arr2);

		System.err.println("ans = " + ans);

		return ans;
	}

}
