import java.util.*;
import java.io.*;

// SWEA #7102 - 준홍이의 카드놀이
// Strategy: Queue
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[] counting = new int[N+M+1];
        	
        	// 숫자별 등장 횟수 저장
        	for(int i=1; i<=N; i++) {
        		for(int j=1; j<=M; j++) {
        			counting[i+j]++;
        		}
        	}
        	
        	// 숫자별 등장 횟수의 최대값 찾기
        	int max = 0;
        	for(int i=2; i<=N+M; i++) {
        		if(counting[i] >= max) {
        			max = counting[i];
        		}
        	}
        	
        	// 확률이 가장 높은 수들 저장
        	Queue<Integer> max_idx = new LinkedList<>();
        	for(int i=2; i<=N+M; i++) {
        		if(counting[i] == max) {
        			max_idx.add(i);
        		}
        	}
        	
        	// 결과 저장
        	sb.append("#").append(t).append(" ");
        	while(!max_idx.isEmpty()) {
        		sb.append(max_idx.poll()).append(" ");
        	}
        	sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}