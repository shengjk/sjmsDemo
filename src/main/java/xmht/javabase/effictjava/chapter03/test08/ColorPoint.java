package xmht.javabase.effictjava.chapter03.test08;

import java.awt.*;

/**
 * @author shengjk1
 * @date 2019-05-15
 */
public class ColorPoint extends Point {
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		System.out.println("bbbbbbbbbbbb");
		return super.equals(o) && ((ColorPoint) o).color == color;
	}
	
	public static void main(String[] args) {
		Point point = new ColorPoint(1, 2, Color.RED);
		ColorPoint colorPoint = new ColorPoint(1, 3, Color.RED);
		System.out.println(point.equals(colorPoint));
		System.out.println(colorPoint.equals(point));
		System.out.println(colorPoint.equals(colorPoint));
		System.out.println(point.equals(point));
		
		
		
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1.equals(str2));
		System.out.println(str1==str2);
	}
	
}
