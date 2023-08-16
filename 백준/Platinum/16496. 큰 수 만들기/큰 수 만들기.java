import java.io.*;
import java.util.*;

// BJ #16496 - 큰 수 만들기
// Strategy: 
public class Main {
	public static class Big implements Comparable<Big>{
		String s;

		public Big(String s) {
			this.s = s;
		}
		
		public int compareTo(Big o) {
			int len = s.length();
			int o_len = o.s.length();
			StringBuilder ss = new StringBuilder();
			StringBuilder os = new StringBuilder();
			ss.append(s).append(o.s);
			os.append(o.s).append(s);
			
			for(int i=0; i<len + o_len; i++) {
				if(ss.charAt(i) != os.charAt(i)) {
					return ss.charAt(i) - os.charAt(i);
				}
			}
			return 0;
		}
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Big> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
        	String tmp = st.nextToken();
        	pq.add(new Big(tmp));
        }
        
        while(!pq.isEmpty()) {
        	sb.append(pq.poll().s);
        }
        
        // 최종 결과 출력
        if(sb.charAt(0) == '0') {
        	System.out.println(0);
        }else {
        	System.out.println(sb);
        }
        
    }
}