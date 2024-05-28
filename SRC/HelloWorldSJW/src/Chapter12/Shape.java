package chapter12;

public class Shape<T> {

	public static <T, V> Point<T, V> makeRectangle(Point<T, V> p1, Point<T, V> p2) {
		return p1;
	}

	public static void main(String[] args) {
		
		Shape<String> sp = new Shape<String>();
		
		Point<Integer, Double> p1 = new Point<>(900, 9.9);
		Point<Integer, Double> p2 = new Point<>(77700, 77.9);
		
//		double dd = Shape.makeRectangle(p1, p2);
//		System.out.println(dd);
	
	}
	
}
