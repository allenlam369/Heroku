package java_coffee_cup.puzzle.remainder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		// ----------- line 1 ----------------
		int N = Integer.parseInt(in.nextLine()); // width of each letter

		// ----------- following N lines ----------------
		for (int i = 0; i < N; i++) {
			String line = in.nextLine();
			list.add(line);
		}

		String ans = Solution.process(list, N);
		System.out.println(ans);
	}

	public static String process(List<String> list, int n) {
		ConditionsSet cs = new ConditionsSet();

		long maxM = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			String[] ss = list.get(i).split("\\s");
			long m = Long.parseLong(ss[0]);
			long r = Long.parseLong(ss[1]);
			if (m > maxM) {
				maxM = m;
			}

			Condition c = new Condition(m, r);
//			System.err.println(c);
			cs.list.add(c);

		} // for
		System.err.println("maxM " + maxM);

		String ans = null;

		if (maxM <= 1000) {
			ans = BruteForce.process(cs.list, maxM);
		}

		else {
			cs.resolveNonCoPrime();
			for (Condition c : cs.list) {
				System.err.println(c);
			}
			long x = crt(cs.list);
			ans = String.valueOf(x);
		}

		return ans;
	}

//	private static boolean passTest(ConditionsSet cs, long x) {
//		for (Condition c : cs.list) {
//			if (x % c.m != c.r) {
//				return false;
//			}
//		}
//		return true;
//	}

	private static long crt(List<Condition> list) {
		int n = list.size();
		long M = 1;
		for (Condition c : list) {
			M *= c.m;
		}

		long[] mm = new long[n];
		long[] mt = new long[n];

		for (int i = 0; i < n; i++) {
			mm[i] = M / list.get(i).m;
		}
		for (int i = 0; i < n; i++) {
			Condition c = list.get(i);
			long mmm = mm[i];
			while (mmm % c.m != c.r) {
				mmm += mm[i];
			}
			mt[i] = mmm;
		}

		long max = Long.MIN_VALUE;
		for (Condition c : list) {
			if (c.m > max) {
				max = c.m;
			}
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mt[i];
		}

		long k = sum / M;
		long x = sum - M * k;
		if (x < max) {
			x = sum - M * (k - 1);
		}
		return x;
	}

}

class ConditionsSet {
	List<Condition> list = new ArrayList<>();

	public void resolveNonCoPrime() {
		List<Condition> extra = new ArrayList<>();
		for (Condition c : list) {
			extra.addAll(c.factorize());
		}

//		System.err.println("extra=" + extra);

		list = cleanList(extra);

//		System.err.println(list);
	}

	public List<Condition> cleanList(List<Condition> eList) {

		Collections.sort(eList, new Comparator<Condition>() {
			@Override
			public int compare(Condition c0, Condition c1) {
				int result = Long.compare(c0.m, c1.m);
				if (result == 0) {
					return Integer.compare(c0.p, c1.p);
				} else {
					return result;
				}
			}
		});

		// unique list of m
		Set<Long> mSet = new HashSet<>();
		for (Condition c : eList) {
			if (c.m > 1) {
				mSet.add(c.m);
			}
		}

		List<Condition> cleanedList = new ArrayList<>();
		for (Long m : mSet) {
			List<Condition> conList = new ArrayList<>();
			for (Condition c : eList) {
				if (c.m == m) {
					conList.add(c);
				}
			}
			if (conList.size() > 1) {
				// find the one with max power
				int maxP = Integer.MIN_VALUE;
				Condition maxpCon = null;
				for (Condition c1 : conList) {
					if (c1.p > maxP) {
						maxP = c1.p;
						maxpCon = c1;
					}
				}
				cleanedList.add(maxpCon);
			} else {
				cleanedList.add(conList.get(0));
			}
		} // for set

		for (Condition e : cleanedList) {
			if (e.p > 1) {
				e.m = (long) Math.pow(e.m, e.p);
				e.p = 1;
			}
			if (e.r > e.m) {
				e.r %= e.m;
			}
		}

		return cleanedList;
	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}

class Condition {
	long m, r;
	int p = 1;

	public Condition(long m, long r) {
		this.m = m;
		this.r = r;
	}

	public Condition(long m, long r, int p) {
		this.m = m;
		this.r = r;
		this.p = p;
	}

	List<Condition> factorize() {
		List<Condition> cList = new ArrayList<>();
		List<Long> pList = toPrimes(this.m);
		Map<Long, Integer> map = new HashMap<>();
		for (Long p : pList) {
			if (map.get(p) == null) {
				map.put(p, 1);
			} else {
				map.put(p, map.get(p) + 1);
			}
		}
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			long p = entry.getKey();
			cList.add(new Condition(p, r, entry.getValue()));
		}

		return cList;
	}

	// list out all prime factors, with duplicates
	private static List<Long> toPrimes(long num) {
		List<Long> list = new ArrayList<>();
		int n;
		for (long i = 2; i <= num; i++) {
			n = 0;
			while (num % i == 0) {
				num /= i;
				n++;
			}
			if (n != 0) {
				for (int j = n; j > 0; j--) {
					list.add(i);
				}
			}
		} // for

		return list;
	}

	@Override
	public String toString() {
		return "Condition [m=" + m + ", r=" + r + ", p=" + p + "]";
	}

}
