import java.io.*;
public class IntList {
 	private int numElements;
 	private int[] data;

	public IntList() {
		this.numElements = 0;
		this.data = new int[100];
	}

	public IntList(int size) {
		this.numElements = 0;
		this.data = new int[size];
	}

 	public void add(int number) {
 		this.data[this.numElements] = number;
		this.numElements++;
 	}

 	public String toString() {
 		String retVal = Integer.toString(data[0]);
 		for(int i = 1; i < this.numElements; i++) {
 			retVal += ", " + data[i];
 		}
 		return retVal;
 	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < numElements; i++) {
			sum += this.data[i];
		}
		return sum;
	}

	public int indexOf(int value) {
		for (int i = 0; i < this.numElements; i++) {
			if (this.data[i] == value) {
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

		for (int var : this.data) {
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
