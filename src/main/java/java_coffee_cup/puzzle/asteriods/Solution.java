package java_coffee_cup.puzzle.asteriods;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();
		int h = in.nextInt();
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int t3 = in.nextInt();

	}

	public static String process(int w, int h, int t1, int t2, int t3, List<String> sList) {
		Map<Character, Points> map = new HashMap<>();

		for (int y = 0; y < h; y++) {
			String line = sList.get(y);
			for (int x = 0; x < w; x++) {
				char c1 = line.charAt(x);
				char c2 = line.charAt(x + w + 1);

				if (c1 != '.') {
					Points ps1 = map.get(c1);
					if (ps1 == null) {
						ps1 = new Points();
						map.put(c1, ps1);
					}
					ps1.add(new Point(x, y), 0);
				}

				if (c2 != '.') {
					Points ps2 = map.get(c2);
					if (ps2 == null) {
						ps2 = new Points();
						map.put(c2, ps2);
					}
					ps2.add(new Point(x, y), 1);
				}
			} // for x
		} // for y

		for (Map.Entry<Character, Points> entry : map.entrySet()) {
			Points pts = entry.getValue();
			int x1 = pts.ps[0].x;
			int x2 = pts.ps[1].x;
			int y1 = pts.ps[0].y;
			int y2 = pts.ps[1].y;

			int d1 = t2 - t1;
			int d2 = t3 - t2;

			// y3 = (y2-y1)/d1 = (y3-y1)/(d1+d2)
			int x3 = Math.floorDiv((x2 - x1) * (d1 + d2), d1) + x1;
			int y3 = Math.floorDiv((y2 - y1) * (d1 + d2), d1) + y1;
			pts.ps[2] = new Point(x3, y3);
		} // for map

		List<Character> cList = new ArrayList<>(map.keySet());
		Collections.sort(cList, Collections.reverseOrder());

		char[][] arr = new char[w][h];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				arr[x][y] = '.';
			}
		}

		for (Character c : cList) {
			Points pts = map.get(c);
			int x = pts.ps[2].x;
			int y = pts.ps[2].y;
			if (x >= 0 && y >= 0 && x < w && y < h) {
				arr[x][y] = c;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				sb.append(arr[x][y]);
			}
			sb.append('\n');
		}
//		System.out.println(sb.toString().trim());
		return sb.toString();
	}
}

class Points {
	Point[] ps = new Point[3];

	public void add(Point pt, int i) {
		ps[i] = pt;
	}
}
