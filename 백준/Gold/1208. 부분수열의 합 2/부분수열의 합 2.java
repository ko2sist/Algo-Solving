import java.util.*;
import java.io.*;

// BJ #1208 - 부분수열의 합2
// Strategy: 


public class Main {
	static int N, S;
	static long res;
	static int[] nums;
	static long[] sums;
	
	// 부분수열의 합 구하기 (index: 0 ~ 2/N-1까지)
	public static void back_f(int idx, int sum) {
		if(idx == N/2) {
			sums[sum+4000000]++;
			return;
		}
		
		back_f(idx+1, sum);
		back_f(idx+1, sum+nums[idx]);
	}
	
	// 부분수열의 합 구하기 (index: N/2 ~ N-1까지)
	public static void back_b(int idx, int sum) {
		if(idx == N) {
			res += sums[S-sum+4000000];
			return;
		}
		
		back_b(idx+1, sum);
		back_b(idx+1, sum+nums[idx]);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0L;
		sums = new long[8000001];
		
		back_f(0,0);

		back_b(N/2,0);
		
		if(S==0) {
			System.out.println(res-1);
		}else {
			System.out.println(res);
		}
		
		
	}
}