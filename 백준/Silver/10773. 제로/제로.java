import java.io.*;
import java.util.*;

// BJ #10773
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<K; i++) {
        	int n = Integer.parseInt(br.readLine());
        	if(n == 0) {
        		st.pop();
        	}else {
        		st.push(n);
        	}
        }
        
        int sum = 0;
        while(!st.isEmpty()) {
        	sum += st.pop();
        }
        	
        System.out.println(sum);
    }
}