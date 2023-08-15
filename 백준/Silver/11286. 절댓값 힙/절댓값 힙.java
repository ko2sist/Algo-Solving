import java.io.*;
import java.util.*;

// BJ #11286 - 절댓값 힙
// Strategy:
public class Main {
	public static class Abs implements Comparable<Abs>{
		int n;
		
		
		public Abs(int n) {
			this.n = n;
		}


		public int compareTo(Abs o) {
			if(Math.abs(n) == Math.abs(o.n)) {
				return n-o.n;
			}else {
				return Math.abs(n) - Math.abs(o.n);
			}
			
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Abs> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	
        	if(tmp == 0) {
        		if(pq.isEmpty()) {
        			sb.append(0).append("\n");
        		}else {
        			sb.append(pq.poll().n).append("\n");
        		}
        		
        	}else {
        		pq.add(new Abs(tmp));
        	}
        }
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}