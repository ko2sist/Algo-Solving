import java.util.*;
import java.io.*;

// BJ #7891
// Strategy: 

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        Integer T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	sb.append(x+y).append("\n");
        }
        
        System.out.println(sb);
	}
}