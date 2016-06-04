
public class recursion {
	public static void rec(String s) {
		System.out.println(s);
		rec(s);
	}

	public static void rec2(String s) {
		if (s.length() == 0) {
			return;
		}
		System.out.println(s);
		rec2(s.substring(1, s.length()));
	}

	public static void usingforloop(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.substring(i, s.length()));
		}
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}

	public static int factorialTail(int n) {
		return factorialTailReal(n, 1);
	}

	private static int factorialTailReal(int n, int result) {
		if (n <= 1) {
			return result;
		} else {
			return factorialTailReal(n - 1, result * n);
		}
	}

	public static int getMax(int[] x) {
		return getMaxRec(x, 0);
	}

	private static int getMaxRec(int[] x, int start) {
		if (start == x.length - 1) {
			return x[start];
		}
		int max = getMaxRec(x, start + 1);
		if (x[start] > max) {
			return x[start];
		} else {
			return max;
		}
	}

	public static int getMaxIter(int[] x) {
		int max = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}

		return max;
	}

	public static void hanoi(int n) {
		hanoiRec(n, 1, 2, 3);
	}

	private static void hanoiRec(int n, int from, int mid, int to) {
		if (n == 1) {
			System.out.println("Move " + n + " from " + from + " to " + to);
		} else {
			hanoiRec(n - 1, from, to, mid);
			System.out.println("Move " + n + " from " + from + " to " + to);
			hanoiRec(n - 1, mid, from, to);
		}
	}

	private static void Merge(int[] l, int start, int end) {
		int[] result = new int[end - start + 1];
		int mid = start + (end - start) / 2;

		int j = start;
		int k = mid + 1;
		for (int i = start; i <= end; i++) {
			if (j <= mid && k <= end) {
				if (l[j] < l[k]) {
					result[i - start] = l[j];
					j++;
				} else {
					result[i - start] = l[k];
					k++;
				}
			} else if (j > mid) {
				result[i - start] = l[k];
				k++;
			} else if (k > end) {
				result[i - start] = l[j];
				j++;
			}
		}
		
		for (int i = start; i <= end; i++) {
			l[i] = result[i - start];
		}
	}

	public static void MergeSort(int[] l, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		MergeSort(l, start, mid);
		MergeSort(l, mid + 1, end);
		Merge(l, start, end);
	}
	
	public static int knapsack(int start, int[] items, int weight) {
		if (start >= items.length) {
			return 0;
		}
		
		if (items[start] > weight) {
			return knapsack(start + 1, items, weight); 
		} else {
			int max = 0;
			int a = items[start] + knapsack(start + 1, items, weight - items[start]);
			int b = knapsack(start + 1, items, weight);
			
			if (a > b) {
				max = a;
			} else {
				max = b;
			}
			
			return max;
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l = new int[] { 1, 2, 4, 5, 3, 6, 5, 3, 2, 5, 6, 7, 4 };
		MergeSort(l, 0, 12);
		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i]);
		}
		
		System.out.println(knapsack(0, new int[] {6,1,7,5,3}, 15));
	}

}
