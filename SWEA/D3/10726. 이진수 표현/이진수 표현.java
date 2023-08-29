import java.util.*;
import java.io.*;

// SWEA #10726 - 이진수 표현
// Strategy: 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String res = "ON";
			for(int i=0; i<N; i++) {
				if(M % 2 == 0) {
					res = "OFF";
					break;
				}
				M = M >> 1;
			}
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
