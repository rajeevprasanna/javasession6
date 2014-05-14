package serializationExamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeCat {
	
	public static void main(String[] args) {
		Collar c = new Collar(3);
		Dog d = new Dog(c, 5);
		System.out.println("before: collar size is " + d.getCollar().getCollarSize());
		
		//start serialization
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");

			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//start deserialization
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after:  collar size is "
				+ d.getCollar().getCollarSize());

	}
}
