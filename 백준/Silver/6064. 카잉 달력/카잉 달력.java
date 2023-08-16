import java.util.*;
import java.io.*;

// BJ #6064 - 카잉 달력
// Strategy: 중국인의 나머지 정리, 확장 유클리드 호제법
public class Main {
	// EE: 확장 유클리드 호제법
	public static long[] EE(int a, int b) {
		if(b == 0) {
			return new long[] {a,1,0};
		}
		long[] tmp = EE(b, a%b);
		
		return new long[] {tmp[0], tmp[2], tmp[1]-(a/b)*tmp[2]};
	}
	
	// cal: 카잉달력 계산 by 중국인의 나머지 정리
	public static long cal(int M, int N, int x, int y) {
		long[] tmp = EE(M,N);
		long gcd = tmp[0];
		
		if((y-x) % gcd != 0) {	// 베주 항등식에 의해 x-y가 gcd의 배수가 아니면 계산 불가
			return -1;
		}else {
			long k0 = tmp[1];
			long res = (M * k0 * ((y-x)/gcd) + x) % (M * N / gcd);
			while(res <= 0) {
				res += M * N / gcd;   // M*N/gcd -> lcm of M and N
			}
			return res;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
//			if(M < N) {
//				int tmp = M;
//				int tmp2 = x;
//				M = N;
//				N = tmp;
//				x = y;
//				y = tmp2;
//			}
			
			sb.append(cal(M,N,x,y)).append("\n");

		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
