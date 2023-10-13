import java.util.*;
import java.io.*;

// BJ #
// Strategy: 

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.print((int)(0.78*N)+" ");
        System.out.println((int)(0.8*N + 0.2*0.78*N));
	}
}