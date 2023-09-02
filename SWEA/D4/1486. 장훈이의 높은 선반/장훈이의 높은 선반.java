import java.util.*;
import java.io.*;

// SWEA #1486 - 장훈이의 높은 선반
// Strategy: 
public class Solution {
	static int N,B,min;
	static int[] height;
	
	public static void back(int num, int sum) {
		if(sum >= min) return;	// 현재까지 쌓인 탑의 높이가 기존에 완성한 탑의 높이 보다 높으면 안됨
		
		if(num == N) {
			if(sum >= B) {		// 최종적으로 만든 탑의 높이는 B 이상이어야 함
				min = sum;
			}
			return;
		}
		
		// height[num] 선택
		back(num+1, sum+height[num]);
		
		// height[num] 미선택
		back(num+1, sum);
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// N: 점원 수
			B = Integer.parseInt(st.nextToken());	// B: 탑 높이 하한선
			
			// 점원들의 키 저장
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			// 만들 수 있는 탑의 높이 중 B이상인 것 중에서 가장 작은 값
			min = Integer.MAX_VALUE;
			
			// 재귀 실행
			back(0,0);
			
			// 현재 테스트케이스 결과 저장
			sb.append("#"+t+" ").append(min - B).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}