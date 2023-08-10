import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // Scan n
            int n = sc.nextInt();

            // copy of n
            int n2 = n;

            // 2d array for saving result
            int[][] snail = new int[n][n];

            // Value
            int val = 1;

            // Current row and column
            int row = 0; int col = -1;


            while (n2>0) {
                // Direction: right
                for (int i=0; i<n2; i++){
                    col++;
                    snail[row][col] = val;
                    val++;
                }

                // decrease n2 and check the break condition
                n2--;
                if (n2==0){
                    break;
                }

                // Direction: down
                for (int i=0; i<n2; i++){
                    row++;
                    snail[row][col] = val;
                    val++;
                }

                // Direction: left
                for (int i=0; i<n2; i++){
                    col--;
                    snail[row][col] = val;
                    val++;
                }

                // decrease n2
                n2--;
                

                // Direction: up
                for (int i=0; i<n2; i++){
                    row--;
                    snail[row][col] = val;
                    val++;
                }
            }


            // Print the result
            System.out.println("#"+test_case);
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    System.out.print(snail[i][j]+" ");
                }
                System.out.println("");
            }		
		}
	}
}