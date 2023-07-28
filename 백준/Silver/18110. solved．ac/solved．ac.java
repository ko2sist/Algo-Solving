import java.io.*;
import java.util.*;

// BJ #18110
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
        
        int sum = 0;
        int r = Math.round(0.15f*n);
        for(int i=0; i<r; i++) {
        	pq.poll();
        }
        for(int i=0; i<n-2*r; i++) {
        	sum += pq.poll();
        }
        	
        System.out.println(Math.round(sum/(double)(n-2*r)));
    }
}