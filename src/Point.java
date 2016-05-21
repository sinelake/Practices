public class Point {
	private int x;
	private int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}

class NamedPoint extends Point {
	private String name;

	// Constructors!
	public NamedPoint() {
		name = "";
	}

//	public NamedPoint(int d1, int d2, String pointName) {
//		setX(d1);
//		setY(d2);
//		name = pointName;
//	}

	public NamedPoint(int d1, int d2, String pointName) {
		super(d1, d2);
		name = pointName;
	}
}