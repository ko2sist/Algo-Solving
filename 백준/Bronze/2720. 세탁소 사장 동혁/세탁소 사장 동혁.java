import java.util.*;
import java.io.*;

// BJ #2720
// Strategy: 

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        Integer T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	int C = Integer.parseInt(br.readLine());
        	
        	sb.append(C/25).append(" ");
        	C %= 25;
        	sb.append(C/10).append(" ");
        	C %= 10;
        	sb.append(C/5).append(" ");
        	C %= 5;
        	sb.append(C).append("\n");
        }
        
        System.out.println(sb);
	}
}