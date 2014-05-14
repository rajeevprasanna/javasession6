package inheritanceVsSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SuperNotSerial {

	public static void main(String[] args) {

		inheritanceVsSerialization.Dog d = new inheritanceVsSerialization.Dog(35, "Fido");
		System.out.println("before: d.name => " + d.name + "  and d.weight => " + d.weight);

		try {
			FileOutputStream fs = new FileOutputStream("testSer1.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream("testSer1.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (inheritanceVsSerialization.Dog) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// The key here is that because Animal is not serializable, when the Dog
		// was deserialized, the Animal constructor ran and reset the Dog's
		// inherited weight variable.
		System.out.println("After: d.name => " + d.name + "  and d.weight => " + d.weight);

		// Because Animal is NOT serializable, any state maintained in the
		// Animal class, even though the state variable is inherited by the Dog,
		// isn't going to be restored with the Dog when it's deserialized! The
		// reason is, the (unserialized) Animal part of the Dog is going to be
		// reinitialized just as it would be if you were making a new Dog (as
		// opposed to deserializing one). That means all the things that happen
		// to an object
		// during construction, will happen but only to the Animal parts of a
		// Dog. In other words, the instance variables from the Dog's class will
		// be serialized and deserialized correctly, but the inherited variables
		// from the non-serializable Animal superclass will come back with their
		// default/initially assigned values rather than the values they had at
		// the time of serialization.

		// If you are a serializable class, but your superclass is NOT
		// serializable, then any instance variables you INHERIT from that
		// superclass will be reset to the values they were given during the
		// original construction of the object. This is because the non-
		// serializable class constructor WILL run!

		// In fact, every constructor ABOVE the first non-serializable class
		// constructor will also run, no matter what, because once the first
		// super constructor is invoked, (during deserialization), it of course
		// invokes its super constructor and so on up the inheritance tree.
	}
}
