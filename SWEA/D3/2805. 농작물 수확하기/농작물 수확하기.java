import java.util.*;
import java.io.*;

// SWEA #2805 - 농작물 수확하기
// Strategy:  
class Solution {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	// N: 농장 크기
        	int N = Integer.parseInt(br.readLine());
        	
        	// sum: 전체 수익
        	int sum = 0;
        	
        	// 수익 계산
        	for(int i=0; i<N; i++) {
        		String s = br.readLine();
        		for(int j=0; j<N; j++) {
        			if(i <= N/2) {
        				if(j <= N/2 + i && j>= N/2 - i) {
        					sum += Character.getNumericValue(s.charAt(j));
        				}
        			}else {
        				if(j <= N/2 + (N-1-i) && j>= N/2 - (N-1-i)) {
        					sum += Character.getNumericValue(s.charAt(j));
        				}
        			}
        		}
        	}
        	
            sb.append("#"+t).append(" ").append(sum).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}
