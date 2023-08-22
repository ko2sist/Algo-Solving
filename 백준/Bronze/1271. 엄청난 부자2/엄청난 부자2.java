import java.util.*;
import java.io.*;
import java.math.BigInteger;

// BJ #1271 - 엄청난 부자2
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		
		BigInteger[] res = n.divideAndRemainder(m);
		sb.append(res[0]).append("\n");
		sb.append(res[1]).append("\n");

		System.out.println(sb);

	}
}
