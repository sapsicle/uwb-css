//This class represents a box with a width, height, and depth.
//The variable grade is a measure of the thickness of the cardboard
//used to construct the box.

public class Box{

	private int width, depth, height, grade;

	//class constructor
	public Box(int width, int height, int depth, int grade)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.grade = grade;
	}

	public Box(Box other) {
		this(other.width, other.height, other.depth, other.grade);
	}

	//Two boxes should be considered equivalent if their volume is
	//the same and they are constructed out of the same grade of cardboard.
	//returns true if they are equivalent and false otherwise
	public boolean equals(Box b)
	{
		return this.getVolume() == b.getVolume() && this.getGrade() == b.getGrade();
	}

	//If this Box is larger than the argument Box b
	//then return this Box - otherwise return b
	public Box larger(Box b) {
		if(b.getVolume() > this.getVolume()) return new Box(b);
		else return new Box(this);
	}

	//Simple getter methods
	public int getGrade() {
		return this.grade;
	}

	public int getVolume()
	{
		return (this.width - (2 * this.grade)) * 																	// internal volume is the product of
			   (this.height - (2 * this.grade)) * 																	// the walls minus the grade on both sides
			   (this.depth - (2 * this.grade));																		// grade 1 has volume (A - 2) * (B - 2) * (C - 2)
	}

	public int getWidth()
	{
		return this.width;
	}

	public double getHeight()
	{
		return this.height;
	}

	public int getDepth()
	{
		return this.depth;
	}
}

