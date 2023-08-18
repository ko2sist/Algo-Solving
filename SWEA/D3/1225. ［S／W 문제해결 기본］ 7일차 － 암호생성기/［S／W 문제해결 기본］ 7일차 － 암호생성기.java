import java.util.*;
import java.io.*;

// SWEA #1225 - 암호생성기
// Strategy: Queue
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        for(int t=1; t<=10; t++) {
        	
        	int T = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	Queue<Integer> q = new LinkedList<>();
        	
        	// 숫자 저장
        	for(int i=0; i<8; i++) {
        		q.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	// 암호화
        	int desc = 1;
        	while(true) {
        		int tmp = q.poll();
        		
        		if(tmp-desc <= 0) {
        			q.add(0);
        			break;
        		}
        		q.add(tmp-desc);
        		
        		if(desc == 5) {
        			desc = 1;
        		}else {
        			desc++;
        		}
        	}
        	
        	// 결과 저장
        	sb.append("#"+t).append(" ");
        	while(!q.isEmpty()) {
        		sb.append(q.poll()).append(" ");
        	}
        	sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}