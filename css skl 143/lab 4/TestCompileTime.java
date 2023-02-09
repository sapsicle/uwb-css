public class TestCompileTime {

	public TestCompileTime() {}

	public static void main(String args[]) {
		if(Debug.dmode) System.err.println("Debug is turned on");
  		else System.out.println("Debug is turned off");

		// TestCompileTime t = new TestCompileTime();        														unused object
		int[] numbers = new int[4];
		for (int i = 0; i < 4; i++) {
		  numbers[i] = i;
		  if (Debug.dmode) System.out.println("DEBUG_STATEMENT: number[" + i + "] = " + i);
		}
		for (int i = 0; i < 4; i++) {
		  int element = numbers[i];
		  System.out.print(element + ", ");
		}
		System.out.println();
	}



}