
import java.io.*;
public class TestExceptions{
    public static void main(String[] args) throws IOException {

        //Open the Input file
        File inputFile = new File("Sample.jpg");
        //Open the Output file
        File outputFile1 = new File("Output1.jpg");

        //Get file handlers in Byte Stream format
        FileInputStream in1 = null;
        try {
            in1 = new FileInputStream(inputFile);
        } catch (IOException e) {
            System.err.println("File not found");
            System.exit(0);
        }
        
        FileOutputStream out1 = null;
        try {
            out1 = new FileOutputStream(outputFile1);
        } catch (IOException e) {
            System.err.println("File could not be found or created");
            System.exit(0);
        }

        int c1;

        while ((c1 = in1.read()) != -1){   //Until end of file
            out1.write(c1);
        }

        //Close the files
        in1.close();
        out1.close();
    }
}


