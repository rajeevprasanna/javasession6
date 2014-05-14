package serializationExamples;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDog {
	
	public static void main(String[] args) {
		Collar c = new Collar(3);
		Dog d = new Dog(c, 8);
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
			
			//What did we forget? The Collar class must ALSO be Serializable. If we modify the Collar class and make it serializable, then there's no problem:
			//class Collar implements Serializable { // same }

			//refer Working class : SerializeDogWorking.java
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
