import java.util.*;
import java.io.*;

// BJ #2096 - 내려가기
// Strategy: DP
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] table = new int[N+1][3];
		int[][] res_max = new int[N+1][3];
		int[][] res_min = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			res_max[i][0] = Math.max(res_max[i-1][0], res_max[i-1][1]) + table[i][0];
			res_max[i][1] = Math.max(Math.max(res_max[i-1][0], res_max[i-1][1]), res_max[i-1][2]) + table[i][1];
			res_max[i][2] = Math.max(res_max[i-1][1], res_max[i-1][2]) + table[i][2];
			
			res_min[i][0] = Math.min(res_min[i-1][0], res_min[i-1][1]) + table[i][0];
			res_min[i][1] = Math.min(Math.min(res_min[i-1][0], res_min[i-1][1]), res_min[i-1][2]) + table[i][1];
			res_min[i][2] = Math.min(res_min[i-1][1], res_min[i-1][2]) + table[i][2];
		}
		
		int max = Math.max(Math.max(res_max[N][0], res_max[N][1]), res_max[N][2]);
		int min = Math.min(Math.min(res_min[N][0], res_min[N][1]), res_min[N][2]);
		
		System.out.printf("%d %d", max, min);
	}
}