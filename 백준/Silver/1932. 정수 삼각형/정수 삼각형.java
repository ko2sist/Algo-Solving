import java.io.*;
import java.util.*;

// BJ #1932 - 정수 삼각형
// Strategy: DP
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] triangle = new int[n][n];
        
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<=i; j++) {
        		triangle[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[][] res = new int[n][n];
        res[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++) {
        	for(int j=0; j<=i; j++) {
        		if(j==0) {
        			res[i][j] = res[i-1][j] + triangle[i][j];
        		}else if(j==i){
        			res[i][j] = res[i-1][j-1] + triangle[i][j];
        		}else {
        			res[i][j] = Math.max(res[i-1][j-1], res[i-1][j]) + triangle[i][j];
        		}
        	}
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
        	if(res[n-1][i] > max) {
        		max = res[n-1][i];
        	}
        }
        
        // 최종 결과 출력
        System.out.print(max);
    }
}