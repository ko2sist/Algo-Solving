import java.util.*;
import java.io.*;

// SWEA #5215 - 햄버거 다이어트
// Strategy: 
public class Solution {
	static int N, L, max;
	static int[] T, K;
	
	public static void back(int idx, int cal, int score) {
		if(idx == N) {
			if(cal <= L) {
				if(score > max) max = score;
			}
			return;
		}
		
		back(idx+1, cal, score);
		back(idx+1, cal+K[idx], score+T[idx]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// TC: 테스트 케이스 수
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// N: 재료의 수
			L = Integer.parseInt(st.nextToken());	// L: 제한 칼로리
			
			
			T = new int[N];	// T: 맛에 대한 점수
			K = new int[N];	// K: 칼로리
			
			// 재료별 점수, 칼로리 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int ti = Integer.parseInt(st.nextToken());
				int ki = Integer.parseInt(st.nextToken());
				
				T[i] = ti;
				K[i] = ki;
			}
			
			// max : 조건을 만족하는 최대 점수 저장
			max = Integer.MIN_VALUE;
			
			// 재귀 실행
			back(0,0,0);
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
