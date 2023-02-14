import java.io.*;
public class FindFile {
    private final int MAX_FILES;

    private ArrayList foundFiles;                                                                                   // array list to store paths for found files

    // constructor
    public FindFile(int maxFiles) {
        this.MAX_FILES = maxFiles;                                                                                  // set max num of files
        this.foundFiles = new ArrayList();                                                                          // initialize arraylist
    }

    /**
     * Search down a directory tree for all appearances of a given file up to maximum specified upon FindFile object creation
     * @param target file to be searched for
     * @param dirName top level directory to search down from
     * @throws Exception If directory is invalid or maximum number of files found
     */
    public void directorySearch(String target, String dirName) throws Exception {
        File dirFile = new File(dirName);                                                                           // create file object for top level directory
        String[] fileList = dirFile.list();                                                                         // pull immediate contents into array

        if (dirFile.isDirectory()) {                                                                                // dirFile will be directory, but sanity check
            for (int i = 0; i < fileList.length; i++) {
                // System.out.println(fileList[i]);

                File aFile = new File(dirName + "/" + fileList[i]);                                                 // new file object concatenating each entry onto absolute path
                
                // storing strings to see literal values whehn debugging
                // String foo = aFile.getAbsolutePath();
                // String bar = fileList[i];
                
                if (aFile.isDirectory()) {                                                                          // if aFile is a directory therefore has contents
                    directorySearch(target, aFile.getAbsolutePath());                                               // recursive call for target with new path to aFile directory
                } else if (aFile.isFile()) {                                                                        // if aFile is a file not a directory therefore is bottom-level
                    if ((this.foundFiles.size() + 1) > this.MAX_FILES) {                                            // check if at capacity for max files
                        throw new Exception("Exceeded max number of files to find");                                // throw if full
                    } else {
                        if (fileList[i].equals(target)) foundFiles.add(dirName + "/" + fileList[i]);                // if entry matches target name, add to arraylist
                    }
                }
            }
        } else {
            throw new Exception("Directory does not exist");                                                        // redundancy for sanity
        }

        return;                                                                                                     // once done in directory, return (i.e. checked every file, gone down every directory) and go up one to go down another branch
    }

    /**
     * @return number of matching files found
     */
    public int getCount() {
        return this.foundFiles.size();
    }

    /**
     * @return String array with absolute paths of all matching files
     */
    public String[] getFiles() {
        String[] foo = new String[this.foundFiles.size()];
        for (int i = 0; i < foo.length; i++) {
            foo[i] = (String)this.foundFiles.get(i);
        }
        return foo;
    }
}