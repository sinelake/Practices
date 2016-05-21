import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class testClass {
	private int testInt;
	private static final int testInt2 = 18;

	testClass(int n) {
		this.testInt = n;
	}
}

class superClass extends testClass {
	superClass() {
		super(30);
	}
}

class Util {
	public static int sum1D(int[] a) {
		int sum = 0;
		for (int v : a)
			sum += v;
		return sum;
	}

	public static void sum2D(int[][] m) {
		int sum1 = 0, sum2 = 0, sum3 = 0;
		for (int k = 0; k < m.length; k++) {
			sum1 += sum1D(m[k]);
		}

		for (int[] row : m) {
			sum2 += sum1D(row);
		}

		for (int[] row : m) {
			for (int v : row) {
				sum3 += v;
			}
		}

		System.out.println("sum1 : " + sum1);
		System.out.println("sum2 : " + sum2);
		System.out.println("sum3 : " + sum3);
		return;
	}
}

public class TeachingFirst {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> testList = new ArrayList<String>(10);
		testList.add("Bye!");

		test();
		
		int[][] table = { {1,2,3,4,5,6,7,8,9,10},
                {2,3,4,5,6,7,8,9,10,1},
                {3,4,5,6,7,8,9,10,1,2},
                {4,5,6,7,8,9,10,1,2,3},
                {5,6,7,8,9,10,1,2,3,4} };
		
		Util.sum2D(table);

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		while (true) {
			input = r.readLine().toString();
			if (input.compareTo("quit") == 0)
				break;

			collatz(new Integer(input).intValue(), 1);
		}

		System.out.println(testList.get(0));

	}

	private static void collatz(int n, int count) {
		System.out.println(n);
		if (n % 2 == 0)
			n /= 2;
		else
			n = 3 * n + 1;
		if (n == 1) {
			System.out.println(n);
			System.out.println("Count : " + count);
			return;
		} else
			collatz(n, ++count);
	}

	public static void changer(String x, int y) {
		x += "peace";
		y *= 2;
	}

	public static void test() {
		String s = "world";
		int n = 6;
		changer(s, n);

		System.out.println(s);
		System.out.println(n);
	}
}
