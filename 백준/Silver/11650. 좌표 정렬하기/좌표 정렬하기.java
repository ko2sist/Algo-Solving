import java.io.*;
import java.util.*;

// BJ #11650
public class Main {
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
		Set[] x_arr = new TreeSet[200001];
    	for(int i=0;i<x_arr.length;i++) {
    		x_arr[i] = new TreeSet<Integer>();
    	}
    	
    	
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	x_arr[x+100000].add((Integer)y);
        }
        
        for(int i=0; i<200001; i++) {
        	if(x_arr[i].size()!=0) {
        		for(Object n : x_arr[i]) {
        			sb.append(i-100000).append(" ").append(n).append("\n");
        		}
        	}
        }
        
        
        
        System.out.println(sb);
    }
}