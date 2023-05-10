import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams115 {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Count the number of names starting with the alphabet A
		
	}*/
	
	
		//Out of the main block
		//@Test
		public void regular()
		{
			
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Abhijeet");
		myList.add("Doan");
		myList.add("Alexa");
		myList.add("Albert");
		myList.add("Rahul");
		
		int countNames = 0;
		
		for (int i=0; i<myList.size(); i++)
		{
			String singleName =  myList.get(i);
			
			if(singleName.startsWith("A"))
			{
				countNames++;
			}
		}
		System.out.println("There are in total number of names starting with A - " + countNames);
		
		}
		
		
		//@Test
		public void streamFilter()

		{
			
			ArrayList<String> myList = new ArrayList<String>();
			myList.add("Abhijeet");
			myList.add("Doan");
			myList.add("Alexa");
			myList.add("Albert");
			myList.add("Rahul");
			
			//Converting the existing ArrayList into a Stream, then filtering using Lambda expression
			Long myLong = myList.stream().filter(s->s.startsWith("A")).count(); //This is an Intermediate operation, after this filter() method a new stream is created
			//and contains all the names that start with A
			//Applying this .count() is called a Terminal operation, and it only returns a value if .filter() is TRUE
			//Data type for .count() is Long
			System.out.println(myLong);
			
			//Stream.of("Abhijeet", "Doan", "Alexa", "Albert","Rahul").filter(s->s.startsWith("A")); //We can create a Stream like this
			
			Long d = Stream.of("Abhijeet", "Doan", "Alexa", "Albert","Rahul").filter(s->
			{
				s.startsWith("A");
				return true;
			}
					).count();
			System.out.println(d);
			
			
			//3. Print names where number of letters is greater than 4; Here .forEach() is a Terminal option
			myList.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
			
			
			//4. Print names where number of letters is greater than 4, but only the first name
			myList.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
			
			
		}
		
	
		//@Test
		public void streamMap()
		{
			
			ArrayList<String> myList = new ArrayList<String>();
			myList.add("William");
			myList.add("Borat");
			myList.add("bata");
			
			//5. Print the names which have the last letter "a" with converted to Uppercase
			Stream.of("Abhijeeta", "Doan", "Rama", "Albert","Rahul").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			
			//Convert an Array into a List
			List<String> listOfNames =  Arrays.asList("Albert", "Doan", "Rama", "Abhijeeta","Rahul", "Alex");
					
			
			//6. Print the names which have the first letter "a" with converted to Uppercase and sorted
			listOfNames.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			
			//7. Merge 2 lists into one
			//Stream<String> newStream = Stream.concat(myList.stream(), listOfNames.stream());
			//newStream.forEach(s->System.out.println(s));
			
			
			//8. Check if Alex is presented in the list;
			Stream<String> newStream = Stream.concat(myList.stream(), listOfNames.stream());
			boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Alex"));
			Assert.assertTrue(flag);
			System.out.println(flag);
			
		}
		
		
		//@Test
		public void streamCollect()
		{
			
			//Using a List for manipulating data (with Stream) and now going back to having a List .collect(Collectors.toList())
			List<String> listAgain = Stream.of("Abhijeeta", "Doan", "Rama", "Albert","Rahul").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.collect(Collectors.toList());
			System.out.println(listAgain.get(0));
			
			
			
		}
		
		
		@Test
		public void assignment()
		{
			
			//1. There is an Array and form this Array print unique number
			//2. Sort this Array and after sorting to give a third value
			
			//First, we convert this Array into a List
			List<Integer> listOfNumbers = Arrays.asList(3,2,2,7,5,1,9,7);
			
			//1.
			listOfNumbers.stream().distinct().forEach(s->System.out.println(s));
			
			//2.
			List<Integer> sortedList = listOfNumbers.stream().distinct().sorted().collect(Collectors.toList());
			
			System.out.println( sortedList.get(2));
			
		}
		
		
		
		

}
