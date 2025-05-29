import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.print.DocFlavor.INPUT_STREAM;

public class LambdaJava {
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(0,1,2,4,5);
		
		int[] unsorted = { 2,5,2,232,2,22};
		
		
		var inp = Arrays.stream(unsorted).boxed().mapToInt(n->n).summaryStatistics();
		
		System.out.println(inp.getAverage());
		System.out.println(inp.getCount());
		System.out.println(inp.getMax());
		System.out.println(inp.getMin());
		System.out.println(inp.getSum());
		
		/* ***********SUMMARYTATITICS**********
		 int[][] TABLE;
		 IntStream stream = Arrays.stream(TABLE)
				.flatMapToInt(Arrays::stream)
				.filter(num -> num >10);
				
			
		stream.boxed().forEach(num -> System.out.print(num+" "));
		return 1;
		
		 */
		
		/* ***********LIST TO INTSTREAM**********
	
		IntStream st = numbers.stream().mapToInt(n->n);
		
		System.out.println("All elements match: "+ st.allMatch(n -> n > 2));
		System.out.println("Average: "+ st.map(n->n).average());
		System.out.println("First Element: "+st.findFirst());
	    System.out.println("Sum: " + st.sum());
	    System.out.println("Highest num: " + st.max());
	    System.out.println("Lowest num: " + st.min());

		
		/* STREAM ARRAY
		
		
		
		Stream<Integer> st = IntStream.of(unsorted).boxed()
		.sorted(Comparator.reverseOrder());
		
		st.forEach(System.out::println);
		*/
		
		/* ********ARRAYS**********
		Arrays.parallelSort(unsorted);
		IntStream stream1 = Arrays.stream(unsorted).filter(n -> n > 2);
		
		stream1.forEach(System.out::println);
		 
		for(var c: unsorted)
				{
					System.out.println(c);
				}
				
		*/
		
		/* ***********ITERATOR**********
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(4,2,232,2125));
		Iterator<Integer> it = l1.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/
		
		/* *************List*************
		
		numbers
		.stream()
        .filter(num -> num > 2 );
        //.forEach(num -> num+=2);
		
		// *************List 2***********
		List<Integer> num2 = new ArrayList<Integer>(Arrays.asList(2,5,2,3,6));
		num2.add(8);
		
		num2.stream()
		.filter(asd -> asd % 2 == 0);
		//.forEach(asd -> System.out.println("==="+asd));
		
		//***************List 3***********
		List<Integer> a = Arrays.asList(12,2,4,22,1,4)
				.stream()
				.filter(n -> n > 3)
				.toList();
		
		//System.out.println(a);
		
		//*************for Wrapped Array***********
		
		
		
		//for primitive array
		int[] primArr = {
				1,2,3,4
		};
		
		
		String str = "2";
		
		var wr = Integer.valueOf(str); // equals to Integer wr = 2 or Integer wr = new Integer(2);
		var unwrapped = Integer.parseInt(str); // equals to int wr = 2;
		
		Stream<Integer> num = IntStream.of(primArr)
				.boxed()
				.filter(n -> n < 2);
		*/
		
		
		
		
		
	}
	
}


