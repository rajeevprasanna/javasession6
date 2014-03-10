package strings;

public class StringBuilderExample {
	public static void main(String[] args) {
		String x = "abc";
		x.concat("def");
		System.out.println("x = " + x); // output is "x = abc"
		//Because no new assignment was made, the new String object created with the concat() method was abandoned instantly.

		String x1 = "abc";
		x1 = x1.concat("def");
		System.out.println("x1 = " + x1);    // output is "x = abcdef"
		//We got a nice new String out of the deal, but the downside is that the old String "abc" has been lost in the String pool, thus wasting memory.
			
		
		StringBuffer sb = new StringBuffer("abc");
		sb.append("def");
		System.out.println("sb = " + sb);     // output is "sb = abcdef"
		
		
		// All of the StringBuffer methods we will discuss operate on the value
		// of the StringBuffer object invoking the method. So a call to
		// sb.append("def"); is actually appending "def" to itself (StringBuffer
		// sb). In fact, these method calls can be chained to each other for
		// example,
		sb.append("def").reverse().insert(3, "---");
		System.out.println(sb); // output is "fed---cba"

	}
}
