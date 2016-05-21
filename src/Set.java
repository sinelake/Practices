
public class Set {
	private int[] ListofElements;
	private int numElements;

	public Set() {
		this.ListofElements = new int[0];
		this.numElements = 0;
	}

	public Set(int[] list) {
		this();
		for (int i = 0; i < list.length; i++) {
			this.add(list[i]);
		}
	}

	public void add(int x) {
		if (this.contains(x)) {
			return;
		} else {
			int[] newList = new int[this.numElements + 1];

			int index = this.numElements;
			for (int i = 0; i < this.numElements; i++) {
				if (this.ListofElements[i] < x) {
					newList[i] = this.ListofElements[i];
				} else {
					index = i;
					break;
				}
			}
			newList[index] = x;
			for (int i = index + 1; i < this.numElements + 1; i++) {
				newList[i] = this.ListofElements[i - 1];
			}

			this.ListofElements = newList;
			this.numElements++;
		}
	}

	public void remove(int x) {
		if (!this.contains(x)) {
			return;
		} else {
			int[] result = new int[this.numElements - 1];

			int index = this.numElements - 1;
			for (int i = 0; i < this.numElements; i++) {
				if (this.ListofElements[i] != x) {
					result[i] = this.ListofElements[i];
				} else {
					index = i;
					break;
				}
			}
			for (int i = index; i < this.numElements - 1; i++) {
				result[i] = this.ListofElements[i + 1];
			}

			this.ListofElements = result;
			this.numElements--;
		}
	}

	public boolean contains(int x) {
		for (int i = 0; i < this.numElements; i++) {
			if (this.ListofElements[i] == x) {
				return true;
			}
		}
		return false;
	}

	public boolean isSubsetOf(Set x) {
		for (int i = 0; i < this.numElements; i++) {
			if (x.contains(ListofElements[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean equals(Set x) {
		return (this.isSubsetOf(x) && x.isSubsetOf(this));
	}

	public int size() {
		return this.numElements;
	}

	public String toString() {
		String result = new String();
		for (int i = 0; i < this.numElements; i++) {
			result += String.valueOf(this.ListofElements[i]) + " ";
		}

		return result;
	}

	public Set intersection(Set x) {
		Set result = new Set();
		for (int i = 0; i < this.numElements; i++) {
			if (x.contains(this.ListofElements[i])) {
				result.add(this.ListofElements[i]);
			}
		}

		return result;
	}

	public Set union(Set x) {
		Set result = new Set();

		for (int i = 0; i < this.numElements; i++) {
			result.add(this.ListofElements[i]);
		}
		for (int i = 0; i < x.numElements; i++) {
			result.add(x.ListofElements[i]);
		}
		return result;
	}

	public Set subtract(Set x) {
		Set result = new Set();

		for (int i = 0; i < this.numElements; i++) {
			result.add(this.ListofElements[i]);
		}
		for (int i = 0; i < x.numElements; i++) {
			result.remove(x.ListofElements[i]);
		}
		return result;
	}

	public static void setTest() {
		Set set1 = new Set(new int[] { 1, 3, 12, 4, 0, 0, 1, 2, -5, -4, -1, 1, 9, 341, -148 });
		Set set2 = new Set(new int[] { 234, 1, 3, -1, -2, -2, -2, -2, -2, -2, 0 });
		Set set3 = set1.intersection(set2);
		Set set4 = set2.intersection(set2);
		Set set5 = set1.union(set2);
		Set set6 = set4.subtract(set1);

		System.out.println(set1.toString());
		System.out.println(set2.toString());
		System.out.println(set3.toString());
		System.out.println(set4.toString());
		System.out.println(set5.toString());
		System.out.println(set6.toString());
		
		System.out.println(set2.equals(set4));
		System.out.println(set5.isSubsetOf(set1));
		System.out.println(set1.isSubsetOf(set5));
		System.out.println(set1.isSubsetOf(set1));
		set1.remove(10);
		set1.remove(12);
		set1.remove(-148);
		set1.remove(341);
		set1.remove(341);
		set1.remove(-4);
		set1.add(-4);
		set1.remove(-5);
		System.out.println(set1.contains(1245));
		System.out.println(set1.size());
		System.out.println(set1.contains(-4));
		set1.remove(0);
		set1.remove(1);
		set1.remove(2);
		set1.remove(3);
		set1.remove(4);
		set1.remove(9);
		set1.remove(124);
		System.out.println(set1.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		setTest();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time : " + (endTime - startTime));
	}

}
