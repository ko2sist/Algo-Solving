import java.io.*;
import java.util.*;

// BJ #11053 - 가장 긴 증가하는 부분 수열
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
		
		int[] len = new int[N];
		for(int i=0; i<N; i++) {
			len[i] = 1;
		}
		
		int max = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					len[i] = Math.max(len[j]+1, len[i]);
					if(len[i] > max) {
						max = len[i];
					}
				}
			}
		}
		

		// 최종 결과 출력
		System.out.print(max);
	}
}