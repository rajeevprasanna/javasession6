package inheritanceVsSerialization;

import java.io.Serializable;

class Dog extends Animal implements Serializable {

	private static final long serialVersionUID = 176575L;

	String name;

	Dog(int w, String n) {
		weight = w;// inherited
		name = n;// not inherited
	}
}