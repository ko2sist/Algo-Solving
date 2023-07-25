import java.io.*;
import java.util.*;

// BJ #2164
public class Main {
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        
        int tmp = 0;
        
        for(int i=0; i<N; i++) {
        	q.add(i+1);
        }
        
        while(!q.isEmpty()) {
        	tmp = q.poll();
        	if(q.isEmpty()) {
        		break;
        	}else {
        		tmp = q.poll();
        		q.add(tmp);
        	}
        }
        
        
        
        System.out.println(tmp);
        
    }
}