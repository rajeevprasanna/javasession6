package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

// https://gist.github.com/rajeevprasanna/9286203
public class FileCreator {
	public static void main(String[] args) {

		// When you make a new instance of the class File, you're not yet making
		// an actual file, you're just creating a filename. Once you have a File
		// object, there are several ways to make an actual file

		try { // warning: exceptions possible
			boolean newFile = false;
			File file = new File("fileWrite1.txt");
			// it's only an object
			System.out.println(file.exists()); // look for a real file
			
			//remember new File() doesn't create a file on the disk! The createNewFile() method created an actual file, and returned true,
			newFile = file.createNewFile(); // maybe create a file!
			System.out.println(newFile); // already there?
			System.out.println(file.exists()); // look again
			
			//creating a directory
			//Be careful when you're creating new directories! As we've seen, constructing a Writer or a Stream will often create a file for you automatically if one doesn't exist, but that's not true for a directory
			File myDir = new File("mydir"); // create an object
			myDir.mkdir();
			File myFile = new File(myDir, "myFile.txt");
			myFile.createNewFile();
			PrintWriter pw = new PrintWriter(myFile);
			pw.println("new stuff");
			pw.flush();
			pw.close();
			
			
			
			
			File myDir1 = new File("mydir1");
			// myDir.mkdir();
			File myFile1 = new File(
			              myDir, "myFile1.txt");
			myFile1.createNewFile();
			// call to mkdir() omitted!
			// exception if no mkdir!
			
			
			
			
			//TO check if directory already exists or not
			File existingDir = new File("existingDir"); // assign a dir
			System.out.println(existingDir.isDirectory());
			
			
			//You can refer a File object to an existing file or directory. For example, assume that we already have a subdirectory called existingDir in which resides an existing file existingDirFile.txt, which contains several lines of text. When you run the following code,
			File existingDirFile = new File(existingDir, "existingDirFile.txt");
			System.out.println(existingDirFile.isFile());
			FileReader fr = new FileReader(existingDirFile);			  
			BufferedReader br = new BufferedReader(fr);			 
			String s;
			
			//Take special note of what the readLine() method returns. When there is no more data to read, readLine() returns a null this is our signal to stop reading the file.
			//Also, notice that we didn't invoke a flush() method. When reading a file, no flushing is required, so you won't even find a flush() method in a Reader kind of class.
			while ((s = br.readLine()) != null)
				System.out.println(s);
			br.close();
			
			
			//Deleting and renaming files
			File delDir = new File("deldir");
			delDir.mkdir();
			
			File delFile1 = new File(delDir, "delFile1.txt");
			delFile1.createNewFile();
			
			File delFile2 = new File(delDir, "delFile2.txt");
			delFile2.createNewFile();
						
			delFile1.delete();
			System.out.println("delDir is " + delDir.delete());
			
			File newName = new File(delDir, "newName.txt");
			delFile2.renameTo(newName);
			File newDir = new File("newDir");
			delDir.renameTo(newDir);
			//delete() You can't delete a directory if it's not empty, which is why the invocation delDir.delete() failed
			//renameTo() You must give the existing File object a valid new File object with the new name that you want. (If newName had been null we would have gotten a NullPointerException.)
			//renameTo() It's okay to rename a directory, even if it isn't empty.

			
			//Search for a file:
			String[] files = new String[100];
			File search = new File("searchThis");
			files = search.list();
			for(String fn : files)
			  System.out.println("found " + fn);
			// create the list
			// iterate through it
			
		} catch (IOException e) {
	}
}
}
