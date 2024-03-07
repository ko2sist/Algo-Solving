import java.io.*;
import java.util.*;

// BJ #1715 - 카드 정렬하기
// Strategy: 

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 숫자 카드 묶음 개수
		N = Integer.parseInt(br.readLine());
		
		// 숫자 카드 크기 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		// 결과 계산
		int result = 0;	// 필요한 총 비교 횟수를 저장
		while(pq.size() >= 2) {	// pq의 size가 2보다 작을 경우 모든 카드 묶음이 합쳐진 것
			// 가장 작은 크기의 카드 묶음 2개 뽑기
			int x = pq.poll();
			int y = pq.poll();
			
			// 카드 묶음을 합쳐서 result에 횟수를 저장하고 합쳐진 카드 묶음을 다시 pq에 넣기
			pq.add(x+y);
			result += x+y;
		}
		
		// 최종 결과 출력
		System.out.println(result);
	}
}