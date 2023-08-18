import java.util.*;
import java.io.*;

// SWEA #3499 - 퍼펙트셔플
// Strategy: Queue
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	Queue<String> q_odd = new LinkedList<>();
        	Queue<String> q_even = new LinkedList<>();
        	
        	// 카드 이름 저장 
        	for(int i=1; i<=N; i++) {
        		if(i <= (N+1)/2) {
        			q_odd.add(st.nextToken());
        		}else {
        			q_even.add(st.nextToken());
        		}
        	}
        	
        	// 결과 저장
        	sb.append("#").append(t).append(" ");
        	for(int i=1; i<=N; i++) {
        		if(i % 2 == 1) {
        			sb.append(q_odd.poll()).append(" ");
        		}else {
        			sb.append(q_even.poll()).append(" ");
        		}
        	}
        	sb.append("\n");
        		
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}