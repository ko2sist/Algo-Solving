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
		
		// 1001*1001 평면에서 결과 탐색 범위를 좁히기 위한 행,열의 max 정보 저장 
		int max_i = 0;
		int max_j = 0;
		
		// 색종이 정보 저장
		int[][] plane = new int[1001][1001];
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			
			// max 정보 갱신
			if(I+ii >= max_i) {
				max_i = I+ii;
			}
			if(J+jj >= max_j) {
				max_j = J+jj;
			}
			
			// 평면에 색종이 번호 표시
			for(int k=I; k<I+ii; k++) {
				for(int l=J; l<J+jj; l++) {
					plane[k][l] = i;
				}
			}
		}
		
		// 저장해놓은 행,열의 max 정보를 통해 탐색 범위를 좁히고
		// 범위 내의 평면을 탐색하며 색종이 번호별 빈도수 저장
		int[] nums = new int[N+1];
		for(int i=0; i<max_i; i++) {
			for(int j=0; j<max_j; j++) {
				nums[plane[i][j]]++;
			}
		}
		
		// 결과 저장
		for(int i=1; i<N+1; i++) {
			sb.append(nums[i]).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
