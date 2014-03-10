package strings;

//https://gist.github.com/rajeevprasanna/9285447
public class ImmutablesStringTest1 {
	
	public static void main(String[] args) {
		String x = "Java";
		x.concat(" Rules!");
		System.out.println("x = " + x); // the output is: x = Java

		x.toUpperCase();
		System.out.println("x = " + x);// the output is still x = Java

		String x1 = "Java";
		x1 = x1.concat(" Rules!"); // Now we're assigning the
									// new String to x
		System.out.println("x1 = " + x1);

		
		
		// Create new strings
		String s = "abc"; // creates one String object and one reference
							// variable

		
		
		// In below case, because we used the new keyword, Java will create a
		// new String object in normal (nonpool) memory, and s will refer to it.
		// In addition, the literal "abc" will be placed in the pool.
		String s1 = new String("abc"); // creates two objects, and one reference
										// variable

	}
}
