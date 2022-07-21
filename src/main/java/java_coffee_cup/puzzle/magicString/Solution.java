package java_coffee_cup.puzzle.magicString;

import java.util.*;

class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		if (in.hasNextLine()) {
			in.nextLine();
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = in.nextLine();
			list.add(s);
		}
		process(list);
	}

	static String process(List<String> list) {
		boolean sml = false;

		Collections.sort(list);
		for (String s : list) {
			System.err.println(s);
		}

		int size = list.size();
		String s1 = list.get(size / 2 - 1);
		String s2 = list.get(size / 2);

		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 > len2) {
			s2 += getDots(len1 - len2);
		} else if (len2 > len1) {
			s1 += getDots(len2 - len1);
		}
		int len = len1;

		char[] arr = new char[len];
		for (int i = 0; i < len; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 == c2) {
				if (!sml) {
					arr[i] = c1;
					if (len2 > len1 && i + 1 == len1) {
						break;
					}
				} else {
					arr[i] = (char) (c1 + 1);
					break;
				}
			} else {
				if (!sml) {
					if (c1 < c2 && i == len - 1) {
						arr[i] = c1;
						break;
					} else if (c1 + 1 < c2) {
						arr[i] = (char) (c1 + 1);
						break;
					} else if (c1 + 1 == c2) {
						if (i == len2 - 1) {
							arr[i] = c1;
							sml = true;
						} else {
							arr[i] = (char) (c1 + 1);
							break;
						}
					}
				} else {
					if (i == len - 1) {
						arr[i] = c1;
						break;
					} else {
						if (c1 + 1 <= 'Z') {
							arr[i] = (char) (c1 + 1);
							break;
						} else {
							arr[i] = c1;
						}
					}
				}
			}
		} // for i

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (arr[i] >= 'A') {
				sb.append(arr[i]);
			} else {
				break;
			}
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}

	private static String getDots(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('.');
		}
		return sb.toString();
	}
}