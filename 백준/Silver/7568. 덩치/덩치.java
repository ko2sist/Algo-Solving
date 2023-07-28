import java.io.*;
import java.util.*;

// BJ #7568
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
			if(this.x < o.x && this.y < o.y) {
				return 1;
			}else {
				return 0;
			}
				
		}
	}
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int xx = Integer.parseInt(st.nextToken());
        	int yy = Integer.parseInt(st.nextToken());
        	arr[i] = new Pair(xx,yy);
        }
        
        for(int i=0; i<N; i++) {
        	int tmp = 0;
        	for(int j=0; j<N; j++) {
        		tmp += arr[i].compareTo(arr[j]);
        	}
        	sb.append(tmp+1).append(" ");
        }
        
        System.out.println(sb);
    }
}