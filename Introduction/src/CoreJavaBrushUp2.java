import java.util.ArrayList;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		for (int abc: arr2)
		{
			System.out.println(abc*2);
		}
		
		
		for (int abc: arr2)
		{
			if (abc % 2==0)
			{
			System.out.println(abc);
			//break; it will stop the first time the condition is achieved
			}
			else
			{
				System.out.println(abc+" is not divided by 2");
			}
		}
		
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("JK");
		a.add("AB");
		a.add("CD");
		System.out.println(a.get(2));
		
		
		
		
		
	}

}
