package serializationExamples;

import java.io.Serializable;

public class Dog implements Serializable {
	 
	private static final long serialVersionUID = 13232L;
	
	private Collar theCollar;
	
	private int dogSize;

	public Dog(Collar collar, int size) {
		theCollar = collar;
		dogSize = size;
	}

	public Collar getCollar() {
		return theCollar;
	}

}