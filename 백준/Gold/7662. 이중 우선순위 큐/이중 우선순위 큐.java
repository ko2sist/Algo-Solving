import java.io.*;
import java.util.*;

// BJ #7662 - 이중 우선순위 큐
// Strategy: TreeMap
public class Main {
	public static class dualPQ{
		TreeMap<Integer, Integer> tm;
		
		public dualPQ() {
			tm = new TreeMap<>();
		}
		
		public void insert(int n) {
			if(tm.containsKey(n)) {
				tm.replace(n, tm.get(n)+1);
			}else {
				tm.put(n, 1);
			}
		}
		
		public void delete_f() {
			if(!tm.isEmpty()) {
				int f_key = tm.firstKey();
				int f_value = tm.get(f_key);
				
				if(f_value == 1) {
					tm.remove(f_key);
				}else {
					tm.replace(f_key, f_value-1);
				}
			}
		}
		
		public void delete_b() {
			if(!tm.isEmpty()) {
				int l_key = tm.lastKey();
				int l_value = tm.get(l_key);
				
				if(l_value == 1) {
					tm.remove(l_key);
				}else {
					tm.replace(l_key, l_value-1);
				}
			}
		}
		
		public int getFirst() {
			return tm.firstKey();
		}
		
		public int getLast() {
			return tm.lastKey();
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	dualPQ dpq = new dualPQ();
        	
        	int k = Integer.parseInt(br.readLine());
        	for(int i=0; i<k; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		char cmd = st.nextToken().charAt(0);
        		int num = Integer.parseInt(st.nextToken());
        		if(cmd == 'I') {
        			dpq.insert(num);
        		}else {
        			if(num == 1) {
        				dpq.delete_b();
        			}else {
        				dpq.delete_f();
        			}
        		}
        	}
        	
        	// 결과 저장
        	if(dpq.tm.isEmpty()) {
        		sb.append("EMPTY");
        	}else {
        		sb.append(dpq.getLast()).append(" ").append(dpq.getFirst());
        	}
        	sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}