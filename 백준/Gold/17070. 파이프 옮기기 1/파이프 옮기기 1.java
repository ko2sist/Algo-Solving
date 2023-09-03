import java.util.*;
import java.io.*;

// BJ #17070 - 파이프 옮기기1
// Strategy: DP
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int[][] res_H = new int[N+1][N+1];
		int[][] res_V = new int[N+1][N+1];
		int[][] res_D = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==1 && j == 2) {
					res_H[i][j] = 1;
					continue;
				}
				
				if(house[i][j] == 1) {
					res_H[i][j] = 0;
					res_V[i][j] = 0;
					res_D[i][j] = 0;
					continue;
				}
				
				res_H[i][j] = res_H[i][j-1]+res_D[i][j-1];
				res_V[i][j] = res_V[i-1][j]+res_D[i-1][j];
				
				if(house[i][j-1] == 1 || house[i-1][j] == 1) continue;
				res_D[i][j] = res_H[i-1][j-1]+res_V[i-1][j-1]+res_D[i-1][j-1];
				
				
			}
		}

//		for(int[] line: res_H) {
//			System.out.println(Arrays.toString(line));
//		}
//		System.out.println();
//		for(int[] line: res_V) {
//			System.out.println(Arrays.toString(line));
//		}
//		System.out.println();
//		for(int[] line: res_D) {
//			System.out.println(Arrays.toString(line));
//		}
		
		
		// 최종 결과 출력
		System.out.println(res_H[N][N] + res_V[N][N] + res_D[N][N]);
	}
}