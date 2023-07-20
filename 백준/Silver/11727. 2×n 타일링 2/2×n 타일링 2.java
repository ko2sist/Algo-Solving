import java.io.*;
//import java.util.*;

// BJ #2475
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n+1];
		nums[0] = 1;
		nums[1] = 1;
		
		for(int i=2; i<n+1; i++) {
			nums[i] = nums[i-1]%10007 + (2*nums[i-2])%10007;
		}
		
		System.out.println(nums[n]%10007);
	}
}