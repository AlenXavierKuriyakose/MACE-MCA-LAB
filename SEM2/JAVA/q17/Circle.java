package graphics;
class Circle implements properties
{
	double r;
	public Circle(double r)
	{
		this.r=r;
	}
	public void area()
	{
		System.out.println("Area of circle:"+3.14*r*r);
	}
	public void perimeter()
	{
		System.out.println("Perimeter of circle:"+2*3.14*r);
	}
}
