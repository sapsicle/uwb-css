import java.io.*;

public class TestFinally{
    public static void main(String[] args) throws IOException, NullPointerException {
        FileInputStream in1 = null;
        FileInputStream in2 = null;

        //Open an existing file trycatch.txt
        File inputFile1 = new File("trycatch.txt");
        //Open a non-existent file nosuchfile.abc
        File inputFile2 = new File("nosuchfile.abc");

		//1. Add the try statement here
        try {

            //Get file handlers in Byte Stream format
            in1 = new FileInputStream(inputFile1);
            in2 = new FileInputStream(inputFile2);
            
            int c1;
            
            //Try to read 'nosuchfile.abc' till the end of File
            while ((c1 = in2.read()) != -1){
                System.out.println("Read from nosuchfile.abc");
            }
        
            //2. Close the try block here
            //3. Add a catch block containing meaningful error messages.
        } catch (IOException e) {
            System.out.println("File not found: " + e);
        } finally {

            //4. Add the finally block here.  See instructions in the handout.


		    //Close the files

            try {
                in1.close();
                System.out.println("Closing file 'trycatch.txt' inside finally block.");
                in2.close();
                System.out.println("Closing file 'nosuchfile.abc' inside finally block.");
            } catch (NullPointerException e) {
                System.err.println("Trying to close a nonexistent object: " + e);
                System.exit(0);
            }

            //5. Close the finally block here.
        }
    }
}


