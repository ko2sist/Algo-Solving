import java.io.*;
import java.util.*;

// BJ #11055 - 가장 큰 증가하는 부분 수열
// Strategy: DP
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N];

		int max = nums[0];
		for(int i=0; i<N; i++) {
			sum[i] = nums[i];
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					sum[i] = Math.max(sum[j]+nums[i], sum[i]);
					if(sum[i] > max) {
						max = sum[i];
					}
				}
			}
		}
		

		// 최종 결과 출력
		System.out.print(max);
	}
}