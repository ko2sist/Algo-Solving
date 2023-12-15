import java.util.*;
import java.io.*;

// BJ #2170 - 선 긋기
// Strategy: 

public class Main {
	public static class Line implements Comparable<Line>{
		int start;
		int end;
		
		public Line(){}
		
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}else {
				return this.start - o.start;
			}
		}		
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        		
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Line> pq = new PriorityQueue<Line>();
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	pq.add(new Line(x,y));
        }
        
        
        int result = 0;
//        Line tmp = pq.poll();
        int start = -1000000001;
        int end = -1000000001;
        while(!pq.isEmpty()) {
        	Line tmp = pq.poll();
        	
        	if(tmp.start > end) {
        		result += (end-start);
        		start = tmp.start;
        		end = tmp.end;
        	}else {
        		if(tmp.end > end) {
        			end = tmp.end;
        		}
        	}
        }
        result += (end-start);
        
        System.out.println(result);
	}
}