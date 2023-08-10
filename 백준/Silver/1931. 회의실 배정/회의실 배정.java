import java.io.*;
import java.util.*;

// BJ #1931 - 회의실 배정
// Strategy: 활동 선택 - 그리디 알고리즘
public class Main {
	// 회의 정보를 저장하는 class
	public static class Meet implements Comparable<Meet>{
		int start;
		int end;
		
		public Meet(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meet o) {
			if(this.end > o.end) {
				return 1;
			}else if(this.end < o.end) {
				return -1;
			}else {
				return this.start - o.start;
			}
		}	
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        
        // N: 회의의 수
        int N = Integer.parseInt(br.readLine());
        
        // pq: 회의들을 저장할 priority queue
        PriorityQueue<Meet> pq = new PriorityQueue<Meet>();
        
        // 회의 저장
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int t1 = Integer.parseInt(st.nextToken());
        	int t2 = Integer.parseInt(st.nextToken());
        	pq.add(new Meet(t1,t2));
        }
        
        // 활동 선택 알고리즘
        int prev_end = 0;
        int res = 0;        // 선택된 회의의 개수 저장
        
        while(!pq.isEmpty()) {
        	Meet tmp = pq.poll();
        	if(tmp.start >= prev_end) {
        		prev_end = tmp.end;
        		res++;
        	}
        }
        
        // 최종 결과 출력
        System.out.println(res);

    }
}