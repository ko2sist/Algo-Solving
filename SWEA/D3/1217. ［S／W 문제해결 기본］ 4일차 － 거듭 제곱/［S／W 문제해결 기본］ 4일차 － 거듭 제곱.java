import java.util.*;
import java.io.*;

// SWEA #1217 - 거듭제곱
class Solution {
	public static int pow(int n, int p) {
		if(p == 1) {
			return n;
		}else {
			return n*pow(n,p-1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: testcase 개수
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int res = pow(N,P);
			
			// 결과 저장
			sb.append("#"+t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
