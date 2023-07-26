import java.io.*;
import java.util.*;

// BJ #10816
public class Main {
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
      
        int[] freq = new int[20000001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	freq[tmp+10000000]++;
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	sb.append(freq[tmp+10000000]).append(" ");
        }
        System.out.println(sb);
        
    }
}