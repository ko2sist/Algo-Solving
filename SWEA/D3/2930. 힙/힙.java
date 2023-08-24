import java.util.*;
import java.io.*;

// SWEA #2930 - 힙
// Strategy:  
class Solution {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	int N = Integer.parseInt(br.readLine());
        	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        	
        	// 연산 실행
        	sb.append("#").append(t).append(" ");
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int c = Integer.parseInt(st.nextToken());
        		
        		if(c == 1) {
        			int n = Integer.parseInt(st.nextToken());
        			pq.add(n);
        		}else {
        			if(pq.isEmpty()) {
        				sb.append(-1).append(" ");
        			}else {
        				sb.append(pq.poll()).append(" ");
        			}
        		}
        	}
            sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}
