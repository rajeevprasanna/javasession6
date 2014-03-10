package inheritanceVsSerialization;

import java.io.Serializable;

class Dog extends Animal implements Serializable {
	
	String name;

	Dog(int w, String n) {
		weight = w;// inherited
		name = n;// not inherited
	}
}