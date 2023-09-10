import java.util.*;
import java.io.*;
import java.math.BigInteger;

// BJ 
// Strategy: 

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger n1 = new BigInteger(st.nextToken());
		BigInteger n2 = new BigInteger(st.nextToken());
		
		System.out.println(n1.add(n2));
	}
}