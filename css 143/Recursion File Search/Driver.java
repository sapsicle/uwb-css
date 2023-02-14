import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Please enter the filename to search for (including extension): ");
        String targetFile = kb.next();
        
        System.out.println("Please enter the absolute path of the top level directory to search from without a trailing slash ");
        System.out.print("NOTE: program coded for Linux directory format: ");
        String pathToSearch = kb.next();
        
        final int MAX_FILES = 10;
        FindFile finder = new FindFile(MAX_FILES);
        
        try {
            finder.directorySearch(targetFile, pathToSearch);
        } catch (Exception e) {
            System.err.println("exception " + e.getMessage());
            System.exit(0);
        }

        String[] foo = finder.getFiles();
        System.out.println("Number of files matching " + targetFile + " found: " + foo.length);
        System.out.println("Paths: ");
        for (String var : foo) {
            System.out.println(var);
        }

        kb.close();
    }
}