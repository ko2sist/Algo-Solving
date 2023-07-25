import java.io.*;
import java.util.*;

// BJ #11047
public class Main {
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<N; i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
        
        int res = 0;
        
        while(K>0) {
        	int tmp = pq.poll();
        	if(K/tmp == 0) {
        		continue;
        	}else {
        		res += K/tmp;
        		K -= tmp*(K/tmp);
        	}
        }
        
        System.out.println(res);
        
    }
}