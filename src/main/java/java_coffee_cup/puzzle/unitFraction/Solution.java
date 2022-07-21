package java_coffee_cup.puzzle.unitFraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		process(n);
		in.close();
	}

	static String process(long n) {
		List<AB> abList = new ArrayList<>();
		long nn = n * n;
		List<Long> list = getFactors(n);

		System.err.println(list);

		for (long b : list) {
			long a = nn / b;
			long aa = a + n;
			long bb = b + n;
			abList.add(new AB(aa, bb));
		}

//		 System.out.println(abList.size());
		StringBuilder sb = new StringBuilder();
		for (AB ab : abList) {
			sb.append(printAns(n, ab.a, ab.b));
		}
		return sb.toString();
	}

	private static String printAns(long n, long a, long b) {
		return String.format("1/%d = 1/%d + 1/%d\n", n, a, b);
	}

	private static List<Long> getFactors(long n) {
		long nn = n * n;
		List<Long> list = new ArrayList<>();
		for (long i = 1; i <= n; i++) {
			if (nn % i == 0) {
				list.add(i);
			}
		}
		return list;
	}
}

class AB {
	long a, b;

	public AB(long a, long b) {
		this.a = a;
		this.b = b;
	}
}
