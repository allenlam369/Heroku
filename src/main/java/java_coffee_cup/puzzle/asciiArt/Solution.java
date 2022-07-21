package java_coffee_cup.puzzle.asciiArt;

import java.util.*;

class Solution {
	static int w, h;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		w = in.nextInt();
		h = in.nextInt();

		char[][] abc = new char[w * 27][h];

		if (in.hasNextLine()) {
			in.nextLine();
		}
		String str = in.nextLine();
		str = str.toUpperCase();

		for (int j = 0; j < h; j++) {
			String row = in.nextLine();
			for (int i = 0; i < w * 27; i++) {
				abc[i][j] = row.charAt(i);
			}
		}

		char[][] solution = new char[w * str.length()][h];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < str.length() * w; x++) {
				int id = x / w; // id of char in input str
				char c = str.charAt(id);
				int id2 = (c - 'A'); // id of this wanted char in abc
				if (id2 < 0 || id2 > 25) {
					id2 = 26;
				}
				int x2 = id2 * w + x % w;
				solution[x][y] = abc[x2][y];
			}
		}

		System.out.println(showArr(solution, h, w * str.length()));
		in.close();
	}

	public static String process(List<String> list, int h, int charW, String text) {
		int w = charW * 27;
		char[][] abc = new char[w][h];

		for (int y = 0; y < h; y++) {
			String str = list.get(y);
			text = text.toUpperCase();
			
			if (str.length() != w) {
				System.err.println("len error: " + str);
			}
			for (int x = 0; x < w; x++) {
				abc[x][y] = str.charAt(x);
			}
		}

		int len = text.length();
		char[][] solution = new char[charW * len][h];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < len * charW; x++) {
				int id = x / charW; // id of char in input str
				char c = text.charAt(id);
				int id2 = (c - 'A'); // id of this wanted char in abc
				if (id2 < 0 || id2 > 25) {
					id2 = 26;
				}
				int x2 = id2 * charW + x % charW;
				solution[x][y] = abc[x2][y];
			}
		}

		String ans = showArr(solution, h, charW * len);

//		System.out.println(ans);
		return ans;
	}

	private static String showArr(char[][] arr, int h2, int w2) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < h2; y++) {
			for (int x = 0; x < w2; x++) {
				sb.append(arr[x][y]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}