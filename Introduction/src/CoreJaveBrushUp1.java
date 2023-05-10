
public class CoreJaveBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'j';
		double decimal = 3.14;
		boolean buli = true;
		
		System.out.println(myNum + " is the value stored in the myNum variable");
		
		//Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 10;
		
		
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		System.out.println(arr2[4]);
		
		
		// FOR loop
		//for (int i=0; i<arr.length; i++)
		//{
			
		//	System.out.println(arr[i]);
		//}
		
		for (int i=0; i<arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
		
		
		String[] name = {"JK","AB","CD"}; 
		for (int j=0; j<name.length; j++) 
		{
			System.out.println(name[j]);
		}
		
		
		for (String s: name)
		{
			System.out.println(s);
		}
		
		
	}

}
