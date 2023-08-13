import java.io.*;
import java.util.*;

// BJ #11279 - 최대 힙
// Strategy: pq(reverse)
public class Main {
	public static class maxHeap{
		private PriorityQueue<Integer> pq;
		
		public maxHeap(){
			this.pq = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		public int poll() {
			if(this.pq.isEmpty()) {
				return 0;
			}else {
				return this.pq.poll();
			}
		}
		
		public void add(int n) {
			pq.add(n);
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        maxHeap mh = new maxHeap();
        
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	
        	if(tmp == 0) {
        		sb.append(mh.poll()).append("\n");
        	}else {
        		mh.add(tmp);
        	}
        }
        
        // 최종 결과 출력
        System.out.println(sb);

    }
}