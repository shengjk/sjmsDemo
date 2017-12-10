package xmht.javabase.java4;

import java.util.Random;

/**
 * Created by shengjk1 on 2017/11/14
 */
public class Shape {
	public void draw(){
		System.out.println("Shape.draw");
	};
	public void erase(){System.out.println("Shape.erase");};
}
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("Circle.draw");
	}
	
	@Override
	public void erase() {
		System.out.println("Circle.erase");
	}
}

class Square extends Shape{
	@Override
	public void draw() {
		System.out.println("Square.draw");
	}
	
	@Override
	public void erase() {
		System.out.println("Square.erase");
	}
}

class Triangle extends Shape{
	@Override
	public void draw() {
		System.out.println("Triangle.draw");
	}
	
	@Override
	public void erase() {
		System.out.println("Triangle.erase");
	}
}

class RandomShapeGenerator{
	private Random random=new Random(47);
	public Shape next(){
		switch (random.nextInt(3)){
			default:
			case 0:return new Circle();
			case 1:return new Square();
			case 2:return new Triangle();
		}
	}
}

class Shapes{
	private static RandomShapeGenerator gen=new RandomShapeGenerator();
	
	public static void main(String[] args) {
		Shape[] shapes=new Shape[9];
		for (int i = 0; i < shapes.length; i++) {
			shapes[i]=gen.next();
		}
		
		for (Shape sha:shapes) {
			sha.draw();
			
		}
	}
}