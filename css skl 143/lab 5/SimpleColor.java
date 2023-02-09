//TODO: if you use this class because you dont have your
//previous SimpleColor, you must document the code with comments
//and fix the setters so they don't invalidate the [0-255] rule
public class SimpleColor {
	private int r;
	private int g;
	private int b;
	
	// getters and setters for RGB values
	public int getR() {
		return r;
	}

	public void setR(int r) throws ColorException {
		if (r >= 0 && r <= 255) {
			this.r = r;
		} else {
			throw new ColorException();
		}
	}

	public int getG() {
		return g;
	}

	public void setG(int g) throws ColorException {
		if (g >= 0 && g <= 255) {
			this.g = g;
		} else {
			throw new ColorException();
		}
	}

	public int getB() {
		return b;
	}

	public void setB(int b) throws ColorException {
		if (b >= 0 && b <= 255) {
			this.b = b;
		} else {
			throw new ColorException();
		}
	}

	// setter for full 3 value color
	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}

	// constructors
	public SimpleColor() {
		this(0, 0, 0);																								// if no values provided, initialize to 0
	}
	
	public SimpleColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
	public SimpleColor(SimpleColor b) {
		this(b.r, b.g, b.b);
	}
	
	// overriden methods
	@Override
	public String toString() {
		return "R: " + this.r + ", G: " + this.g + ", B: " + this.b;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o.getClass() == this.getClass()) || o == null) return false;
		SimpleColor simpleColor = (SimpleColor) o;
		return this.r == simpleColor.r && this.g == simpleColor.g && this.b == simpleColor.b;
	}
}
