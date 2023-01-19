import java.io.*;
public class ObjectList {
    private int numElements;
 	private Object[] myShapes;

	public ObjectList() {
		this.numElements = 0;
		this.myShapes = new Object[100];
	}

	public ObjectList(int size) {
		this.numElements = 0;
		this.myShapes = new Object[size];
	}

 	public void add(Object object) {
 		this.myShapes[this.numElements] = object;
		this.numElements++;
 	}

 	public String toString() {
 		String retVal = "";
 		for(int i = 0; i < this.numElements; i++) {
 			retVal += myShapes[i].toString() + " ";
 		}
 		return retVal;
 	}

	// public int sum() {
	// 	int sum = 0;
	// 	for (int i = 0; i < numElements; i++) {
	// 		sum += this.myShapes[i];
	// 	}
	// 	return sum;
	// }

	public int indexOf(int value) {
		for (int i = 0; i < this.numElements; i++) {
			if (this.myShapes[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public String save() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("data.txt"));
		} catch (IOException e) {
			return "Could not save to disk";
		}

		for (Object var : this.myShapes) {
			pw.println(var);
		}
		pw.close();
		return "Array saved to disk";
	}

 	//main goes here from the lab
	 public static void main(String[] args) { 
		IntList a = new IntList();
		a.add(95);
		a.add(100);
		a.add(58);
		System.out.println(a.toString() );
		System.out.println(a.sum());
		System.out.println(a.indexOf(100)); //uncomment these to work on next
		System.out.println(a.indexOf(20));
		System.out.println(a.save());
	}
}