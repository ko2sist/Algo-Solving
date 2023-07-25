import java.util.Arrays;
import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        // test 횟수 입력 받기
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // N을 입력받는다
            
            int n = sc.nextInt();
            String N = String.valueOf(n);
            
            // 0~9가 나왔는지 체크하기 위한 배열을 받는다
            int[] check = new int[10];
            int k = 0;
            int copy_n = n;
            // 0~9가 나올 때 까지 반복
            while(Arrays.stream(check).sum() != 10){
            	k++;
        		n= copy_n*k;
        		N = String.valueOf(n);
            	for(int i=0; i<N.length(); i++) {
            		
            		int tmp = Character.getNumericValue(N.charAt(i));
            		if(check[tmp] == 0){
            			check[tmp] = 1;
            		}
            		
            	}
            	
            }
            
            System.out.println("#"+test_case+" "+copy_n*k);
        }
    }
}