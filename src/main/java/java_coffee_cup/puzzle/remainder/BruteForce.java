package java_coffee_cup.puzzle.remainder;

import java.util.List;
import java.util.Scanner;

public class BruteForce {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] m = new int[n];
		int[] r = new int[n];

		if (in.hasNextLine()) {
			in.nextLine();
		}
		for (int i = 0; i < n; i++) {
			String str = in.nextLine();
			String[] ss = str.split("\\s");
			m[i] = Integer.parseInt(ss[0]);
			r[i] = Integer.parseInt(ss[1]);
		}
		in.close();

		long M = 1;
		for (int i = 0; i < n; i++) {
			M *= m[i];
		}

		// find the smallest m
		long max = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (m[i] > max) {
				max = m[i];
			}
		}

		System.err.println("max=" + max);

		for (long x = max; x <= Long.MAX_VALUE; x++) {

			// System.err.println(x);

			boolean ok = true;
			for (int i = 0; i < n; i++) {
				if (x % m[i] != r[i]) {
					ok = false;
					break;
				}
			}
			if (ok) {
				System.out.println("x=" + x);
				break;
			}
		}
	}

	public static String process(List<Condition> list, long max) {
		int n = list.size();
		for (long x = max; x <= Long.MAX_VALUE; x++) {

			boolean ok = true;
			for (int i = 0; i < n; i++) {
				Condition c = list.get(i);
				if (x % c.m != c.r) {
					ok = false;
					break;
				}
			}
			if (ok) {
//				System.err.println("x=" + x);
				return String.valueOf(x);

			}
		}

		return null;
	}
}
