package fileWriter;

import java.io.*;

//  https://gist.github.com/rajeevprasanna/9286223
public class Writer2 {
	public static void main(String[] args) {
		char[] in = new char[50];
		int size = 0;
		try {
			File file = new File("fileWrite2.txt");
			// to store input
			// just an object
			
			
			/* 
			 FileWriter fw = new FileWriter(file) did three things:			
				a. It created a FileWriter reference variable, fw.
				b. It created a FileWriter object, and assigned it to fw.
				c. It created an actual empty file out on the disk (and you can prove it).
				*/
			
			FileWriter fw = new FileWriter(file); // create an actual file
			fw.write("howdy\nfolks\n");
			fw.flush();
			fw.close();
			// & a FileWriter obj
			// write characters to
			// the file
			// flush before closing
			// close file when done
			FileReader fr = new FileReader(file); // create a FileReader
			size = fr.read(in);
			System.out.print(size + " ");
			for (char c : in)
				System.out.print(c);
			fr.close();
		} catch (IOException e) {
		}
		
		
		//
		try {
			File file = new File("fileWrite2.txt");			 			
			FileWriter fw = new FileWriter(file); // create an actual file
			PrintWriter pw = new PrintWriter(fw);
			pw.println("howdy");
			pw.println("folks");
			fw.flush();
			fw.close();
			

			FileReader fr = new FileReader(file); // create a FileReader
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();			 
			System.out.println(data);
			br.close();
		} catch (IOException e) {
		}
		
	}
}
