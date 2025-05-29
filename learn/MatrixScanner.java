import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MatrixScanner {
	private static int MINIMUM;
	private static int MIN_COL;
	private static int MIN_ROW;
	private static long TABLE_SUM;
	private static int ROW_TOTAL;
	private static int CURR_ROW = 0;
	private static int CURR_COL = 0 ;
	private static int COL_TOTAL;
	private static int CURR_VALUE;
	private static int NEXT_VAL = 0;
	private static int NEXT_ROW = 0;
	private static int NEXT_COL = 0;
	private static int[][] TABLE;
	
	MatrixScanner(int[][] TABLE)
	{
		this.TABLE=TABLE;
	}
	
	MatrixScanner()
	{
	
	}

	void setRow(int num)
	{
		CURR_ROW=num;
		
	}
	void setColumn(int num)
	{
		CURR_COL=num;
	}
	void setMinimum(int num)
	{
		MINIMUM=num;
		
	}
	void setRowSum(int num)
	{
		ROW_TOTAL=num;
	}
	void setColumnSum(int num)
	{
		COL_TOTAL=num;
	}	
	void setTableSum(int num)
	{
		TABLE_SUM=num;
	}	
	void setMatrix(int[][] arr)
	{
		TABLE = arr;
	}
	int[][] getMatrix()
	{
		return TABLE;
	}
	int getRow()
	{
		return	CURR_ROW;
	}
	int getColumn()
	{
		return	CURR_COL;
	}
	int getMinimum()
	{
		min(TABLE);
		return MINIMUM;
	}
	int getRowMinimum()
	{
		minRow(TABLE, CURR_ROW);
		return MINIMUM;
	}
	int getColumnMinimum()
	{
		minColumn(TABLE, CURR_COL);
		return MINIMUM;		
	}
	int getRowSum()
	{
		rowSum();
		return ROW_TOTAL;
	}
	int getColumnSum()
	{
		colSum();
		return COL_TOTAL;
	}
	long getTableSum()
	{
		sum(TABLE);
		return TABLE_SUM;
	}
	
	void remove(int row, int column)
	{
		TABLE[row][column] = 0;
	}
	
	void remove()
	{
		TABLE[CURR_ROW][CURR_COL] = 0;
	}
	
	int search(int value)
	{
		boolean isMatch= Arrays.stream(TABLE)
				.flatMapToInt(Arrays::stream)
				.anyMatch(n -> n==value);
		if(isMatch) {
			return 1;
			
		}else {
			return 0;
		}		
	}
	
	int nextInt()
	{
		if(NEXT_COL<TABLE[NEXT_ROW].length)
		{
			NEXT_VAL = TABLE[NEXT_ROW][NEXT_COL];
			NEXT_COL++;			
		} 
		else
		{
			NEXT_COL=0;
			NEXT_ROW++;
			NEXT_VAL = TABLE[NEXT_ROW][NEXT_COL];
		}
		
		return NEXT_VAL;
		
		
	}
	
	int rowSum()
	{
		return rowSum(CURR_ROW);
	}
	
	int rowSum(int index)
	{
		ROW_TOTAL = 0;
		CURR_ROW = index;
		for(int i=0; i<TABLE[index].length; i++)
		{
			ROW_TOTAL += TABLE[index][i];

		}
		return ROW_TOTAL;
	}
	
	int colSum()
	{
		return colSum(CURR_COL);
	}
	
	int colSum(int index)
	{
		COL_TOTAL = 0;
		CURR_COL = index;
		for(int i=0; i<TABLE.length; i++)
		{		
			COL_TOTAL += TABLE[i][index];
		}
		return COL_TOTAL;
	}
	
	int minColumn(int[][]arr, int root)
	{	
		MIN_COL = arr[0][root];
		CURR_COL = root;
		int i;
		for(i=0; i<arr.length; i++)
		{
	
			if(root==i)
				{
					if(root == 0)
					{
						MIN_COL = arr[1][root];
					}
					continue;
				}
				
			if(arr[i][root]<=MIN_COL)
				{
					MIN_COL = arr[i][root];
				}
			
		}
		return MIN_COL;
	}
	int minColumn(int root)
	{	
		return minColumn(TABLE, root);
	}
	
	int minRow(int[][]arr, int root)
	{	
		MIN_ROW = arr[root][0];
		CURR_ROW= root;
		for(int i=0; i<arr[root].length; i++)
		{
			
			if(root==i)
			{
				if(root == 0)
				{
					MIN_ROW = arr[root][1];
				}
				continue;
			}
			
			if(arr[root][i]<=MIN_ROW)
			{
				MIN_ROW = arr[root][i];
			}
		}
	
		return MIN_ROW;
	}
	
	int minRow(int root)
	{	
		return minRow(TABLE, root);
	}
	
	long sum(int[][]arr)
	{	
		
		int num = Arrays.stream(arr)
				.flatMapToInt(Arrays::stream)
				.sum();
		TABLE_SUM  = num;
		
		return TABLE_SUM;
	}
	
	int min(int[][]arr)
	{	
		int num = Arrays.stream(arr)
				.flatMapToInt(Arrays::stream)
				.filter(n->n!=0)
				.min().getAsInt();
		MINIMUM = num;

		return MINIMUM;
	}
	
	void print(int[][] arr)
	{
		int length;
		
		for(int i=0;i<arr.length;i++)
	    {

			for(int j=0; j<arr[i].length; j++){
				if(arr[i]==null)
				{
					arr[i][j] = 0;
					
				}
				length=String.valueOf(arr[i][j]).length();
	    		System.out.print(arr[i][j]);
	    		while(length<=5)
	    		{
	    			System.out.print(" ");
	    			length++;
	    		}
	    		System.out.print("|");
	    		
	    	}
	    	System.out.println(" ");
	    }
	}

	
}
