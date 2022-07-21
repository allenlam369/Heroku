package java_coffee_cup.puzzle.lightBulbs;

/**
 * Rewriting v2 to accept two input Strings, Start and Target
 * 
 * Used the gray code algorithm https://en.wikipedia.org/wiki/Gray_code
 * Can directly calculate the transformed value NumberNumber -> GrayCode
 * GrayCode decimal value is the wanted answer.
 */
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long c1 = gray2Num(in.nextLine());
		long c2 = gray2Num(in.nextLine());

		System.out.println((c1 > c2) ? c1 - c2 : c2 - c1);
	}

	public static String process(String st, String ed) {
		long c1 = gray2Num(st);
		long c2 = gray2Num(ed);
		long a = (c1 > c2) ? c1 - c2 : c2 - c1;

		return String.valueOf(a);
	}

	// gray2Binary()
	private static long gray2Num(String s) {
		long n = Long.parseLong(s, 2);
		long mask = n >> 1;
		while (mask != 0) {
			n = n ^ mask;
			mask = mask >> 1;
		}
		return n;
	}

}
