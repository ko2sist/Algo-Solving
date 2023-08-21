import java.util.*;
import java.io.*;

// SWEA #1860 - 진기의 최고급 붕어빵
// Strategy : PQ
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// N: 손님 수
			int M = Integer.parseInt(st.nextToken());	// M: 붕어빵을 만드는 단위시간
			int K = Integer.parseInt(st.nextToken());	// K: 단위시간마다 만드는 붕어빵 수
			
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();	// 손님이 오는 시간을 저장할 PQ
			
			// 손님이 오는 시간 입력
			for(int i=0; i<N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				pq.add(tmp);
			}
			
			// 지연시간 없는 붕어빵 제공 가능/불가능 판단
			String res = "Possible";
			for(int i=1; i<=N; i++) {
				int tmp = pq.poll();
				if((tmp/M)*K < i) {
					res = "Impossible";
				}
			}
			
			// 현재 테스트케이스 결과 저장 
			sb.append("#"+t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
