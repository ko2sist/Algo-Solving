import java.util.*;
import java.io.*;
import java.math.*;

// BJ #2749 - 피보나치 수 3
// Strategy: 도가뉴 항등식, 메모이제이션
public class Main {
	static Map<Long,Long> m;
	static long denom = 1000000L;
	
	public static long Fibo(long n) {
		if(m.containsKey(n)) {
			return m.get(n);
		}
		
		if(n % 2 == 0) {
			m.put(n/2, Fibo(n/2) % denom);
			m.put(n/2-1, Fibo(n/2-1) % denom);
			m.put(n/2+1, Fibo(n/2+1) % denom);
			
			return (Fibo(n/2) * (Fibo(n/2-1) + Fibo(n/2+1))) % denom;
		}else {
			m.put(n/2, Fibo(n/2) % denom);
			m.put(n/2+1, Fibo(n/2+1) % denom);
			
			return (Fibo(n/2+1)*Fibo(n/2+1) + Fibo(n/2)*Fibo(n/2)) % denom;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		m = new HashMap<>();
		m.put(0L, 0L);
		m.put(1L, 1L);
		m.put(2L, 1L);
		
		System.out.println(Fibo(n));
	}
}