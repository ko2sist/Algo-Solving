import java.io.*;
import java.util.*;

// BJ #1149 - RGB 거리
// Strategy: DP
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] cost = new int[N][3];
        int[][] res = new int[N][3];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<3; j++) {
        		cost[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        res[0][0] = cost[0][0];
        res[0][1] = cost[0][1];
        res[0][2] = cost[0][2];
        
        for(int i=1; i<N; i++) {         		       			       		      	
        	res[i][0] = Math.min(res[i-1][1], res[i-1][2]) + cost[i][0];
        	res[i][1] = Math.min(res[i-1][0], res[i-1][2]) + cost[i][1];
        	res[i][2] = Math.min(res[i-1][0], res[i-1][1]) + cost[i][2];      	
        }
        	

        // 최종 결과 출력
        System.out.print(Math.min(Math.min(res[N-1][0], res[N-1][1]), res[N-1][2]));
    }
}