//necessary imports for file i/o
import java.io.*;
import java.util.*;

/**
 * Write a description of class Diary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diary
{
    
  public static void main(String[] args) throws IOException {
    
    // Needed variables
    int mm = 0;
    int dd = 0;
    int yyyy = 0;
    String prose = "";   //Empty string to read prose
    
    PrintWriter output = null;
    try {
      output = new PrintWriter(new FileOutputStream("diaryLog.txt", true));
    } catch (IOException e) {
      System.err.println("File not found");
      System.exit(0);
    }

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the date as three integers separated by spaces (i.e mm dd yyyy) ");
    
    mm = sc.nextInt();
    dd = sc.nextInt();
    yyyy = sc.nextInt();

    output.printf("Date: %02d/%02d/%04d", mm, dd, yyyy);
    
    System.out.println("Enter as many lines of prose you wish (for your to-do's list or diary entry)");
    System.out.print("Enter 'finish' when completed: ");
    
    //START YOUR CODE HERE
    while (sc.hasNextLine()) {
      prose = sc.nextLine();

      if (prose.equalsIgnoreCase("finish")) {
        break;
      }

      System.out.println(prose);
      output.println(prose);
    }
    
    output.println(); //space between entries

    output.close();
    sc.close();
  }
}