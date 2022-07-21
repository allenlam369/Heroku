package java_coffee_cup.puzzle.thomas;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int maxRef;
	static boolean isDebug = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		if (n == 0) {
			System.out.println("0");
			return;
		}
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			int w = in.nextInt();
			arr[j] = w;
		}

		process(arr, n);

	}

	static String process(int[] arr, int n) {
		int[] lisArr = lis(arr, n);

		int[] ldsArr = lds(arr, n);

		if (isDebug) {
			System.err.println("lis = " + Arrays.toString(lisArr));
			System.err.println("lds = " + Arrays.toString(ldsArr));
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int sum = lisArr[i] + ldsArr[i];
			if (sum > max) {
				max = sum;
			}
		}

		max--;

		return String.valueOf(max);
	}

	// longest non-decreasing subseq
	static int[] lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		for (i = n - 2; i >= 0; i--) {
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		return lis;
	}

	// longest non-increasing subseq
	static int[] lds(int arr[], int n) {
		int lds[] = new int[n];
		int i, j;

		/* Initialize LDS values for all indexes */
		for (i = 0; i < n; i++) {
			lds[i] = 1;
		}

		for (i = n - 2; i >= 0; i--) {
			int mx = 0;
			for (j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					// find the largest lds[j]
					if (lds[j] > mx) {
						mx = lds[j];
					}
				}
			}
			lds[i] = mx + 1;
		}

		return lds;
	}
}
