package graphics;
class Square implements properties
{
	int s;
	public Square(int s)
	{
		this.s=s;
	}
	public void area()
	{
		System.out.println("Area of square:"+s*s);
	}
	public void perimeter()
	{
		System.out.println("Perimeter of square:"+4*s);
	}
}
