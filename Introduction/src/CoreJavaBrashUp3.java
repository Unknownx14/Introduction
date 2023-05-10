
public class CoreJavaBrashUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String is an Object in Java
		
		//String literal means the object s1 will not be created since it has the same value as the object s
		//String s = "Rahul Shetty";
		//String s1 = "Rahul Shetty";
		
		
		// New key word is creating both s2 and s3 objects
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		
		
		String s = "Rahul Shetty Academy";
		String [] splittedString = s.split("Shetty");
		
		for (String abc:splittedString)
		{
			System.out.println(abc.trim());
		}
		
		
		// Every string to be printed out
		String s7 = "Rahul Shetty Academy";
		
		for (int i=0; i<s7.length(); i++)
		{
			System.out.println(s7.charAt(i));
		}
		
		
		// Every string to be printed out in a reverse way
				String s8 = "Rahul Shetty Academy";
				
				for (int i=s8.length()-1; i>=0; i--)
				{
					System.out.println(s8.charAt(i));
				}
		
		
		
	}

}
