import java.util.*;
import java.io.*;
import java.math.BigInteger;

// BJ #2338 - 긴자리 계산
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger n1 = new BigInteger(br.readLine());
		BigInteger n2 = new BigInteger(br.readLine());
		
		System.out.println(n1.add(n2));
		System.out.println(n1.subtract(n2));
		System.out.println(n1.multiply(n2));
	}
}
