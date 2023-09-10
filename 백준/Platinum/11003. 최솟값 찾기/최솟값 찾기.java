import java.util.*;
import java.io.*;

// BJ #11003 - 최솟값 찾기
// Strategy: DQ

public class Main {
	public static class Pair{
		int num;
		int idx;
		
		public Pair(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Pair> dq = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.peekLast().num > tmp) {
				dq.pollLast();
			}
			
			if(!dq.isEmpty() && dq.peek().idx < i-(L-1)) {
				dq.pollFirst();
			}
			
			dq.add(new Pair(tmp,i));
			
			sb.append(dq.peekFirst().num).append(" ");
		}
		
		System.out.println(sb);
	}
}