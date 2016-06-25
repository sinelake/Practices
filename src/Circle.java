
public class Circle {
	private double xcenter;
	private double ycenter;
	private double radius;

	public Circle(double xcenter, double ycenter, double radius) {
		this.xcenter = xcenter;
		this.ycenter = ycenter;
		this.radius = radius;
	}
	
	public String toString() {
		String result = new String();
		result += "Center : (" + xcenter + ", " + ycenter + "), Radius = " + radius;
		
		return result;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public boolean intersect(Circle c) {
		double dist;
		dist = Math.sqrt((c.xcenter - this.xcenter) * (c.xcenter - this.xcenter) + (c.ycenter - this.ycenter) * (c.ycenter - this.ycenter));
		
		return (dist <= this.radius + c.radius);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c1 = new Circle (3.0, 4.0, 5.0);
		Circle c2 = new Circle (1.0, 2.0, 3.0);
		Circle c3 = new Circle (10.0, 10.0, 12.0);
		
		System.out.println(c1.toString());
		System.out.println(c1.getArea());
		System.out.println(c1.intersect(c2));
		System.out.println(c1.intersect(c3));
		
		System.out.println(c2.toString());
		System.out.println(c2.getArea());
		System.out.println(c2.intersect(c1));
		System.out.println(c2.intersect(c3));
		
		System.out.println(c3.toString());
		System.out.println(c3.getArea());
		System.out.println(c3.intersect(c1));
		System.out.println(c3.intersect(c2));
		
	}

}
