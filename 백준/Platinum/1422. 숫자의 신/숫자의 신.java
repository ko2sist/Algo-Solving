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
	
	public static class LLong implements Comparable<LLong>{
		String l;
		
		public LLong(String s) {
			this.l = s;
		}
		
		@Override
		public int compareTo(LLong o) {
			if (o == null) {
				return 1;
			}

			int len1 = this.l.length();
			int len2 = o.l.length();
			if(len1 != len2) {
				return len1 - len2;
			}else {
				for(int i=0; i<len1; i++) {
					if(this.l.charAt(i) != o.l.charAt(i)) {
						return this.l.charAt(i) - o.l.charAt(i);
					}
				}
			}
			return 0;
		}
		
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Big> pq = new PriorityQueue<>(Collections.reverseOrder());
        LLong max_LLong = null;
        
        for(int i=0; i<K; i++) {
        	String tmp = br.readLine();
        	LLong tmp_LLong = new LLong(tmp);
        	pq.add(new Big(tmp));
        	if(tmp_LLong.compareTo(max_LLong) > 0) {
        		max_LLong = tmp_LLong;
        	}
        }
        
        boolean check = true;
        for(int i=0; i<K; i++) {
        	String tmp = pq.poll().s;
        	if(check && tmp == max_LLong.l) {
        		for(int j=0; j<N-K+1; j++) {
        			sb.append(tmp);
        		}
        		check = false;
        	}else {
        		sb.append(tmp);
        	}
        }
        
        // 최종 결과 출력
        if(sb.charAt(0) == '0') {
        	System.out.println(0);
        }else {
        	System.out.println(sb);
        }
        
    }
}