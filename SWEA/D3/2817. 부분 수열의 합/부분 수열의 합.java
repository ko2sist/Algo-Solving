import java.util.*;
import java.io.*;

// SWEA #2817 - 부분 수열의 합
// Strategy: 
public class Solution {
	static int N, K, res;
	static int[] nums;
	
	public static void back(int idx, boolean[] selected) {
		if(idx == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					sum += nums[i];
				}
			}
			if(sum == K) res++;
			return;
		}
		
		selected[idx] = false;
		back(idx+1, selected);
		selected[idx] = true;
		back(idx+1, selected);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// N: 자연수 개수
			K = Integer.parseInt(st.nextToken());	// K: 찾으려는 수열의 합
			
			// nums: 수열
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			// res: 수열 합이 K인 수열의 개수
			res = 0;
			boolean[] selected = new boolean[N];
			back(0, selected);
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
