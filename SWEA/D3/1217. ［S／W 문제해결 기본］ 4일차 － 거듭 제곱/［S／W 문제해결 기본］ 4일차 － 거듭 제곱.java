import java.util.*;
import java.io.*;

// SWEA #1217 - 거듭제곱
// Strategy: 
public class Solution {
	public static int pow(int n, int p) {
		if(p == 0) return 1;
		if(p == 1) return n;
		
		int tmp = pow(n, p/2);
		if(p%2 == 0) {
			return tmp*tmp;
		}else {
			return tmp*tmp*n;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 수
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(t).append(" ").append(pow(n,p)).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
