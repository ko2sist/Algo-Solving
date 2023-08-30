import java.util.*;
import java.io.*;

// SWEA #4012 - 요리사
// Strategy: 
public class Solution {
	static int N, min;
	static int[][] S;
	
	public static void back(int idx, boolean[] selected) {
		if(idx == N) {
			int sumA = 0;
			int sumB = 0;
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					for(int j=0; j<N; j++) {
						if(selected[j]) {
							sumA += S[i][j];
						}
					}
				}else {
					for(int j=0; j<N; j++) {
						if(!selected[j]) {
							sumB += S[i][j];
						}
					}
				}
			}
			int res = Math.abs(sumA - sumB);
			if(res < min) min = res;
			
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
			// N: 식재료의 수
			N = Integer.parseInt(br.readLine());	
			
			S = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// min: 음식의 점수 차이가 최소일 때의 점수차 저장
			min = Integer.MAX_VALUE;
			
			// 재귀 실행
			boolean[] selected = new boolean[N];
			back(0,selected);
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
