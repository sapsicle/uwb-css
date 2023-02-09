public class ColorWithAlpha extends SimpleColor {
    private int alpha;

    // getter and setter
    public int getAlpha() {
        return this.alpha;
    }

    public void setAlpha(int a) throws ColorException {
        if (a >= 0 && a <= 255) {
            this.alpha = a;
        } else {
            throw new ColorException();
        }
    }

    // constructors
    public ColorWithAlpha(int a) {
        super();                                                                                                    // no-args defaults to 0
        this.alpha = a;
    }

    public ColorWithAlpha(int r, int g, int b, int a) {
        super(r, g, b);
        this.alpha = a;
    }

    public ColorWithAlpha(ColorWithAlpha cwa) {
        this(cwa.getR(), cwa.getG(), cwa.getB(), cwa.getAlpha());
    }

    // overriden methods
    @Override
	public String toString() {
		return super.toString() + ", Alpha: " + this.getAlpha();
	}

    @Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!super.equals(o)) return false;
		if (!(o instanceof ColorWithAlpha) || o == null) return false;
		ColorWithAlpha colorWithAlpha = (ColorWithAlpha) o;
		return super.equals(colorWithAlpha) && this.getAlpha() == colorWithAlpha.getAlpha();
	}
}