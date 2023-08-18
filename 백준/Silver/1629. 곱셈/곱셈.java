import java.io.*;
import java.util.*;

// BJ #1629 - 곱셈
// Strategy: 
public class Main {
	public static long pow(int a, int b, int c) {
		if(b == 1) {
			return a % c;
		}
		
		long result = pow(a,b/2,c);
		if(b % 2 == 0) {
			return (result * result) % c;
		}else {
			return ((result * result)%c * a) % c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 최종 결과 출력
		System.out.print(pow(A,B,C));
	}
}