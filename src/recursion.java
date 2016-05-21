
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
		for(int i=0;i<x.length;i++) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(5);
		System.out.println(getMax(new int[] {1,4,2,5,87,7,4,1,4,-1,46,0}));
		System.out.println(getMaxIter(new int[] {1,4,2,5,87,7,4,1,4,-1,46,0}));
	}

}
