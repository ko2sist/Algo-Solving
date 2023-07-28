import java.io.*;
import java.util.*;

// BJ #11651
public class Main {
	public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			if(this.y == o.y) {
				return this.x - o.x;
			}else {
				return this.y - o.y;
			}
		}
	}
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int xi = Integer.parseInt(st.nextToken());
        	int yi = Integer.parseInt(st.nextToken());
        	pq.add(new Pair(xi,yi));
        }
        
        while(!pq.isEmpty()) {
        	Pair tmp = pq.poll();
        	sb.append(tmp.x).append(" ").append(tmp.y).append("\n");
        }
        System.out.println(sb);
    }
}