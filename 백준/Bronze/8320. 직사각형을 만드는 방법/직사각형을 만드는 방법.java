import java.util.*;
import java.io.*;

// BJ #8320 - 직사각형을 만드는 방법
// Idea: DP
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		for(int i=1; i<N+1; i++) {
			int max = (int)Math.sqrt(i);
			int cnt = 0;
			for(int j=max; j>0; j--) {
				if(i%j == 0) {
					cnt++;
				}
			}
			nums[i] = nums[i-1] + cnt;
		}
		
		System.out.println(nums[N]);
	}
}
