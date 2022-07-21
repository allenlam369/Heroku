package java_coffee_cup.puzzle.graffiti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int N = in.nextInt();
		List<Section> secList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int st = in.nextInt();
			int ed = in.nextInt();

			if (st >= ed) {
				System.err.println("data ERROR " + st + " " + ed);
			}
			secList.add(new Section(st, ed));
		}
//		process(secList, L);
	}

	static String process(List<String> sList, int L) {
		List<Section> secList = new ArrayList<>();
		for (String str : sList) {
			String[] ss0 = str.split("\\s");
			int st = Integer.parseInt(ss0[0]);
			int ed = Integer.parseInt(ss0[1]);
			secList.add(new Section(st, ed));
		}

		Collections.sort(secList, new Comparator<Section>() {
			@Override
			public int compare(Section o1, Section o2) {
				return Integer.compare(o1.st, o2.st);
			}
		});

		StringBuilder sb = new StringBuilder();
		List<Section> myList = new ArrayList<>();
		int st = 0;
		int ed = 0;
		for (int i = 0; i < secList.size(); i++) {
			Section sec = secList.get(i);
			if (ed < sec.st) {
				ed = sec.st;
				myList.add(new Section(st, ed));
				st = sec.ed;
				ed = sec.ed;
			} else if (ed > sec.st) {
				if (ed < sec.ed) {
					st = sec.ed;
					ed = sec.ed;
				}
			} else {
				st = sec.ed;
				ed = sec.ed;
			}
		}
		if (ed < L) {
			ed = L;
			myList.add(new Section(st, ed));
		}

		if (myList.isEmpty()) {
			System.out.println("All painted");
		}

		else {
			for (Section sec : myList) {
				System.out.println(sec);
				sb.append(sec).append('\n');
			}
		}

		return sb.toString();

	}
}

class Section {
	int st, ed;

	public Section(int st, int ed) {
		this.st = st;
		this.ed = ed;
	}

	@Override
	public String toString() {
		return st + " " + ed;
	}
}