import java.util.*;
import java.io.*;

// SWEA #1966 - 숫자를 정렬하자
// Strategy : PQ
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// N: 입력 받을 정수의 수
			int N = Integer.parseInt(br.readLine());
			
			// 정수들을 저장할 PQ
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			// 정수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			// 현재 테스트케이스 결과 저장 
			sb.append("#"+t).append(" ");
			for(int i=0; i<N; i++) {
				sb.append(pq.poll()).append(" ");
			}
			sb.append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
