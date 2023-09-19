import java.util.*;
import java.io.*;

// SWEA #1952 - 수영장
// Strategy: 백트래킹

public class Solution {
	static int[] price, days;
	static int min;
	
	
	public static void back(int month, int sum) {
		if(sum >= min) return;
		
		if(month > 12) {
			min = sum;
			return;
		}
		
		// 1일 이용권을 사용하는 경우
		back(month+1, sum+price[0]*days[month]);
		// 1달 이용권
		back(month+1, sum+price[1]);
		// 3달 이용권
		back(month+3, sum+price[2]);
		// 1년 이용권
		back(month+12, sum+price[3]);
		
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	price = new int[4];
        	for(int i=0; i<4; i++){
        		price[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	days = new int[13];
        	for(int i=1; i<=12; i++) {
        		days[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	
        	min = Integer.MAX_VALUE;
        	
        	back(1,0);
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ").append(min).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}