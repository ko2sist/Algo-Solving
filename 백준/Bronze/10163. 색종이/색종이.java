import java.util.*;
import java.io.*;

// BJ #10163 - 색종이
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 색종이의 수
		int N = Integer.parseInt(br.readLine());
		
		int max_i = 0;
		int max_j = 0;
		int[][] plane = new int[1001][1001];
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			
			if(I+ii >= max_i) {
				max_i = I+ii;
			}
			if(J+jj >= max_j) {
				max_j = J+jj;
			}
			
			for(int k=I; k<I+ii; k++) {
				for(int l=J; l<J+jj; l++) {
					plane[k][l] = i;
				}
			}
		}
		
		int[] nums = new int[N+1];
		for(int i=0; i<max_i; i++) {
			for(int j=0; j<max_j; j++) {
				nums[plane[i][j]]++;
			}
		}
		for(int i=1; i<N+1; i++) {
			sb.append(nums[i]).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
