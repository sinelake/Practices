
public class Set2 {
	private int[] ListofElements;
	private int numElements;

	public Set2() {
		this.ListofElements = new int[4];
		this.numElements = 0;
	}

	public Set2(int[] list) {
		this();
		for (int i = 0; i < list.length; i++) {
			this.add(list[i]);
		}
	}

	public void add(int x) {
		if (this.contains(x)) {
			return;
		} else {
			if (this.ListofElements.length == this.numElements) {
				int[] newList = new int[this.ListofElements.length * 2];
				for (int i = 0; i < this.numElements; i++) {
					newList[i] = this.ListofElements[i];
				}
				this.ListofElements = newList;
			}
			this.ListofElements[this.numElements] = x;
			this.numElements++;
		}
	}

	public void remove(int x) {
		if (!this.contains(x)) {
			return;
		} else {
			int index = 0;
			for (int i = 0; i < this.numElements; i++) {
				if (this.ListofElements[i] == x) {
					index = i;
					break;
				}
			}
			for (int i = index; i < this.numElements - 1; i++) {
				this.ListofElements[i] = this.ListofElements[i + 1];
			}
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

	public boolean isSubsetOf(Set2 x) {
		for (int i = 0; i < this.numElements; i++) {
			if (x.contains(ListofElements[i])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean equals(Set2 x) {
		return (this.isSubsetOf(x) && x.isSubsetOf(this));
	}

	public int size() {
		return this.numElements;
	}

	public String toString() {
		String result = new String();
		int[] sortedList = bubbleSort(this.ListofElements);
		for (int i = 0; i < this.numElements; i++) {
			result += String.valueOf(sortedList[i]) + " ";
		}

		return result;
	}
	
	private int[] bubbleSort(int[] list) {
		int temp;
		for(int i=0;i<this.numElements-1;i++) {
			for(int j=0;j<this.numElements-1-i;j++) {
				if(list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		return list;
	}

	public Set2 intersection(Set2 x) {
		Set2 result = new Set2();
		for (int i = 0; i < this.numElements; i++) {
			if (x.contains(this.ListofElements[i])) {
				result.add(this.ListofElements[i]);
			}
		}

		return result;
	}

	public Set2 union(Set2 x) {
		Set2 result = new Set2();

		for (int i = 0; i < this.numElements; i++) {
			result.add(this.ListofElements[i]);
		}
		for (int i = 0; i < x.numElements; i++) {
			result.add(x.ListofElements[i]);
		}
		return result;
	}

	public Set2 subtract(Set2 x) {
		Set2 result = new Set2();

		for (int i = 0; i < this.numElements; i++) {
			result.add(this.ListofElements[i]);
		}
		for (int i = 0; i < x.numElements; i++) {
			result.remove(x.ListofElements[i]);
		}
		return result;
	}

	public static void setTest() {
		Set2 set1 = new Set2(new int[] { 1, 3, 12, 4, 0, 0, 1, 2, -5, -4, -1, 1, 9, 341, -148 });
		Set2 set2 = new Set2(new int[] { 234, 1, 3, -1, -2, -2, -2, -2, -2, -2, 0 });
		Set2 set3 = set1.intersection(set2);
		Set2 set4 = set2.intersection(set2);
		Set2 set5 = set1.union(set2);
		Set2 set6 = set4.subtract(set1);

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
		long startTime = System.nanoTime();
		for (int i = 0; i < 1; i++)
			setTest();
		long endTime = System.nanoTime();
		System.out.println("Execution time : " + (endTime - startTime));
	}

}
