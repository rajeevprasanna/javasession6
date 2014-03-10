package writeObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable {

	transient private Collar theCollar; // we can't serialize this
	private int dogSize;

	public Dog(Collar collar, int size) {
		theCollar = collar;
		dogSize = size;
	}

	public Collar getCollar() {
		return theCollar;
	}

	private void writeObject(ObjectOutputStream os) { // throws IOException {

		try {
			// When you invoke defaultWriteObject() from within writeObject()
			// you're telling the JVM to do the normal serialization process for
			// this object. When implementing writeObject(), you will typically
			// request the normal serialization process, and do some custom
			// writing and reading too.
			os.defaultWriteObject();

			// In this case we decided to write an extra int (the collar size)
			// to the stream that's creating the serialized Dog. You can write
			// extra stuff before and/or after you invoke defaultWriteObject().
			// BUT...when you read it back in, you have to read the extra stuff
			// in the same order you wrote it.
			os.writeInt(theCollar.getCollarSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) {
		// throws IOException, ClassNotFoundException { // 4
		try {
			// When it's time to deserialize, defaultReadObject() handles the
			// normal deserialization you'd get if you didn't implement a
			// readObject() method

			// when you want to do only a part of the
			// serialization/deserialization yourself, you MUST invoke the
			// defaultReadObject() and defaultWriteObject() methods to do the
			// rest.
			is.defaultReadObject();
			theCollar = new Collar(is.readInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
