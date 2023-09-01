package graphics;
class Rectangle implements properties
{
	int l;
	int b;
	public Rectangle(int l,int b)
	{
		this.l=l;
		this.b=b;
	}
	public void area()
	{
		System.out.println("Area of rectangle:"+l*b);
	}
	public void perimeter()
	{
		System.out.println("Perimeter of rectangle:"+2*(l+b));
	}
}
