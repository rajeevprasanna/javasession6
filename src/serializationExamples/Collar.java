package serializationExamples;

import java.io.Serializable;

public class Collar implements Serializable {
 
	private static final long serialVersionUID = 1234534543L;
	
	private int collarSize;

	public Collar(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}
}
