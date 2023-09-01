import java.util.*;
import java.io.*;

// SWEA #2806 - N-Queen
// Strategy: 백트래킹

public class Solution {
	static int N, res;
	
	
	public static void back(int num, int[] arr) {
		if (num == N) {	// 모든 퀸을 다 놓았을 경우 res 1 증가 후 종료
			res++;
			return;
		}
		
		loop: for(int i=0; i<N; i++) {
			arr[num] = i;
			for(int j=0; j<num; j++) {
				if(arr[j] == i) continue loop;		// 같은 열에 퀸이 이미 존재할 경우
				if(Math.abs(num-j) == Math.abs(arr[num]-arr[j])) {	//	num-j -> 이미 존재하는 퀸과 현재 놓을 퀸의 열 차이 / i-arr[j] -> 행 차이 
					continue loop;									//  열, 행 차이가 서로 같으면 대각선에 퀸이 존재한다는 뜻
				}
			}
			back(num+1, arr);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// N: 체스판 크기
			N = Integer.parseInt(br.readLine());
			
			// arr: 퀸의 위치를 저장 index는 row를, 저장된 값은 column을 나타낸다
			int[] arr = new int[N];
			
			// res: 체스판에 퀸을 놓을 수 있는 가지수 저장
			res = 0;
			
			// 백트래킹 실행
			back(0, arr);
			
			// 현재 테스트 케이스 결과 출력
			sb.append("#"+t+" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
