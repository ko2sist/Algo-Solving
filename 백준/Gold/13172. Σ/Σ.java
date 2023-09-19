import java.util.*;
import java.io.*;

// BJ #13172 - Σ
// Strategy: 확장 유클리드 호제법을 이용한 모듈러 역원 계산

public class Main {
	static final long Q = 1000000007;
	
	// EE: 확장 유클리드 호제법
	public static long[] EE(long a, long b) {
		if(b == 0) {
			return new long[] {a,1,0};
		}
		long[] tmp = EE(b, a%b);
		
		
		return new long[] {tmp[0], tmp[2], tmp[1]-(a/b)*tmp[2]};
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long res = 0;
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

        	// ax+by = gcd(a,b) 일때  EE(a,b) -> {gcd(a,b), x, y} 반환
        	// **여기서는 a 자리에 Q=1000000007의 소수를 넣기 때문에 gcd(a,b)는 무조건 1, ax+by = by = 1 (mod Q)
            // 따라서 EE(Q,N)[2] -> N의 (mod Q)에 대한 역원
            res += (((EE(Q,N)[2]+Q)%Q) * S) % Q;
        }
        
        System.out.println(res % Q);
    }
}