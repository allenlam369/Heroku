package java_coffee_cup.puzzle.rectanglePartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RectanglePartition {
	static boolean isDebug = false;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();
		int h = in.nextInt();
		int countX = in.nextInt();
		int countY = in.nextInt();
		if (in.hasNextLine()) {
			in.nextLine();
		}

		int[] arr1 = new int[countX + 2];
		int[] arr2 = new int[countY + 2];
		arr1[countX + 1] = w;
		arr2[countY + 1] = h;
		for (int i = 1; i <= countX; i++) {
			arr1[i] = in.nextInt();
		}
		for (int i = 1; i <= countY; i++) {
			arr2[i] = in.nextInt();
		}
		in.close();

		String total = process(w, h, arr1, arr2);
		System.out.println(total);
	}

	public static String process(int w, int h, int[] arr1, int[] arr2) {
		List<Integer> list1 = arr2List(arr1);
		List<Integer> list2 = arr2List(arr2);

		Collections.sort(list1);
		Collections.sort(list2);

		if (isDebug) {
			System.err.println(list1);
			System.err.println(list2);
		}

		int total = 0;
		int i = 0;
		int j = 0;
		while (i < list1.size() && j < list2.size()) {

			if (list1.get(i).intValue() == list2.get(j).intValue()) {
				int ii = i;
				while (i < list1.size() && list1.get(i).intValue() == list1.get(ii).intValue()) {
					if (isDebug) {
						System.err.println(list1.get(ii).intValue());
					}
					i++;
				}

				int jj = j;
				while (j < list2.size() && list2.get(j).intValue() == list2.get(jj).intValue()) {
					if (isDebug) {
						System.err.println(list2.get(jj).intValue());
					}
					j++;
				}
				total += (i - ii) * (j - jj);
			}

			else if (list1.get(i).intValue() < list2.get(j).intValue()) {
				i++;
			} else {
				j++;
			}
		}

		return String.valueOf(total);
	}

	private static List<Integer> arr2List(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				list.add(arr[i] - arr[j]);
			}
		}
		return list;
	}
}
