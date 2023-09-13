import java.util.*;
import java.io.*;

// BJ #10942 - 팰린드롬?
// Strategy: DP

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] res = new int[N+1][N+1];
		
		for(int j=1; j<=N; j++) {
			for(int i=1; i<=j; i++) {
				if(i==j) res[i][j] = 1;
				else if(j == i+1){
					if(nums[i] == nums[j]) res[i][j] = 1;
					else res[i][j] = 0;
				}else {
					if(res[i+1][j-1] == 0) res[i][j] = 0;
					else {
						if(nums[i] == nums[j]) res[i][j] = 1;
						else res[i][j] = 0;
					}
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(res[S][E]).append("\n");
		}
		
		System.out.println(sb);
	}
}
