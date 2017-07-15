
public class TheMatrix 
{
	
	
	//Add matrices
	public int[][] add(int A[][], int B[][])
	{
		int [][]C = {{-1}};
		if(A.length == B.length && 
				A[0].length == B[0].length)
		{
			//I can add
			C = new int[A.length][A[0].length];
			for(int row = 0; row < A.length; row++)
			{
				for(int col = 0; col < A[0].length; col++)
				{	
					C[row][col] = A[row][col] + B[row][col];
				}
			}
			
		}
		else
		{
			//I cannot add
			//Put an error message here
		}
		
		return C;
	}//end add method
	
	//Include Subtract method here
	
	public int[][] subtract(int A[][], int B[][])
	{
		int [][]C = {{-1}};
		if(A.length == B.length && 
				A[0].length == B[0].length)
		{
			//I can add
			C = new int[A.length][A[0].length];
			for(int row = 0; row < A.length; row++)
			{
				for(int col = 0; col < A[0].length; col++)
				{	
					C[row][col] = A[row][col] - B[row][col];
				}
			}
			
		}
		else
		{
			//I cannot add
			//Put an error message here
		}
		
		return C;
	}
	
	
	
	
	
	public int[][] multiplyByScalar(int A[][], int scalar)
	{
		int [][] C = new int[A.length][A[0].length];
		for(int row = 0; row < A.length; row++)
		{
			for(int col = 0; col < A[0].length; col++)
			{
				C[row][col] = A[row][col] * scalar;
			}
		}
		return C;
		
	}
	
	
	 public int[][] multiply(int[][] A, int[][] B) 
	 {
		 int[][] C ={{-1}};
	      
		     //Multiplication is possible
	        if (A[0].length == B.length)
	        {
	            C = new int[A.length][B[0].length];		
	            
		        for (int row = 0; row < A.length; row++)
		        {
		            for (int col = 0; col < B[0].length; col++)
		            {
		                for (int k = 0; k < A[0].length; k++)
		                {
		                    C[row][col] += A[row][k] * B[k][col];
		                }
		            }
		        }
	        	
	        }
	        else
	        {
	        	    //Put an error message here
	        }
	        
	        return C;
	    }
	 
	   public void printArray(int array[][])
		{
			for(int row = 0; row < array.length; row++)
			{
				for(int col = 0; col < array[0].length; col++)
				{
					System.out.print(array[row][col] + " ");
				}	
				System.out.println();
			}
		} 

}
