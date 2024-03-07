import java.io.*;
import java.util.*;

// BJ #11000 - 강의실 배정
// Strategy: 

public class Main {
	static int N;
	
	public static class Class implements Comparable<Class>{
		int s;
		int t;
		
		public Class(int s, int t) {
			this.s = s;
			this.t = t;
		}

		@Override
		public int compareTo(Class o) {
			if(this.s == o.s) {
				return this.t-o.t;
			}
			return this.s - o.s;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 강의 개수
		N = Integer.parseInt(br.readLine());
		
		// pq: 강의들을 저장할 우선 순위 큐
		PriorityQueue<Class> pq = new PriorityQueue<>();
		
		// 강의 저장
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			pq.add(new Class(S,T));
		}
		
		// pq2: 강의들의 끝나는 시간을 저장할 우선 순위 큐
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		// 강의실 수 계산
		while(!pq.isEmpty()) {	// pq가 빌 때 까지 아래의 과정 실행
			Class tmp = pq.poll();	// 시작시간이 가장 빠른 강의(시작 시간이 같다면 종료 시간이 더 빠른 강의) 뽑기
			
			if(!pq2.isEmpty() && pq2.peek() <= tmp.s) {	// 현재 강의가 진행 중이고 현재 뽑은 강의가 이전 강의랑 겹치지 않을 때
				pq2.poll();	// pq2에서 이전 강의 제거
			}
			pq2.add(tmp.t);	// pq2에 현재 뽑은 강의의 끝나는 시간 저장
		}
		
		// 최종 결과 출력(pq에서 모든 강의를 뽑았을 때 pq2의 크기가 필요한 강의실의 개수가 됨)
		System.out.println(pq2.size());
		
	}
}