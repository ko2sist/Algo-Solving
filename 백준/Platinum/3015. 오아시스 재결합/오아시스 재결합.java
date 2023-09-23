import java.util.*;
import java.io.*;

// BJ #3015 - 오아시스 재결합
// Strategy: Stack

public class Main {
	public static class Pair{
		int num;
		int cnt;
		
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long cnt = 0;
		int N = Integer.parseInt(br.readLine());
		Stack<Pair> s = new Stack<>();
		
		
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			Pair p = new Pair(tmp,1);
			
			while(!s.isEmpty() && s.peek().num <= tmp) {
				Pair pop = s.pop();
				cnt += pop.cnt;
				if(pop.num == tmp) {
					p.cnt += pop.cnt;
				}
			}
			
			if(!s.isEmpty()) cnt++;
			
			s.add(p);

		}
		
		System.out.println(cnt);
    }
}