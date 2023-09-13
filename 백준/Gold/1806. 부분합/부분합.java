import java.util.*;
import java.io.*;

// BJ #1806 - 부분합
// Strategy: two pointer

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			nums[i] = tmp;
		}
		
		
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int start=0; start<N; start++) {
			while(sum < S && end < N) {
				sum += nums[end];
				end += 1;
			}
			
			if(sum >= S) {
				if(end - start < min) min = end - start;
			}
			
			sum -= nums[start];
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
		
	}
}
