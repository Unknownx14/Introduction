
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodsDemo d = new MethodsDemo();
		String something = d.getData();
		System.out.println(something);
		getData2();
		String something3 = getData2();
		System.out.println(something3);
		
		
		
		MethodsDemo2 d2 = new MethodsDemo2();
		String something2= d2.getUserData();
		System.out.println(something2);
		
		
	}

	//My own created method
		public String getData()
		{
			System.out.println("Hello World");
			return "Rahul Shetty";
		}
	
		
		//My own created static method2
				public static String getData2()
				{
					System.out.println("Hello World Static");
					return "Rahul Shetty Static";
				}
		
		
		
		
		
}
