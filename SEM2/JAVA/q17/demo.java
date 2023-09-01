import java.util.*;
import graphics.*;
public class demo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length and breadth of rectangle:");
		int l=sc.nextInt();
		int b=sc.nextInt();
		Rectangle r=new Rectangle(l,b);
		System.out.println("Enter 3 sides of triangle:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		Triangle t=new Triangle(a,b,c);
		System.out.println("Enter side of a square:");
		int s=sc.nextInt();
		Square sq=new Square(s);
		System.out.println("Enter radius of circle:");
	        double r=sc.nextDouble();
		Circle ci=new Circle(r);
		r.area();
		r.perimeter();
		t.area();
		t.perimeter();
		sq.area();
		sq.perimeter();
		ci.area();
		ci.perimeter();
	}
}
