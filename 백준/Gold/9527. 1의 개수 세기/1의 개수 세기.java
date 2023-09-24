import java.util.*;
import java.io.*;

// BJ #9527 - 1의 개수 세기
// Strategy: 비트마스킹

public class Main {
	static long A,B;
	static long[] res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		res = new long[55];
		res[0] = 1L;
		for(int i=1; i<55; i++) {
			res[i] = (res[i-1] << 1) + (1L << i);
		}
		
		System.out.println(getOnes(B) - getOnes(A-1));
	}
	
	public static long getOnes(long n) {
		long cnt = n & 1;	// 0번째 bit 처리
		int len = (int) (Math.log(n) / Math.log(2)); // -> log_2(n)의 정수부분
		
		for(int i=len; i>0; i--) {
			if((n & (1L << i)) != 0L) {
				cnt += res[i-1] + (n - (1L << i) + 1);
				n -= (1L << i);
			}
		}
		
		return cnt;
	}
}