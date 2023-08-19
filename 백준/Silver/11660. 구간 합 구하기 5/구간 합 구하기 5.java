import java.io.*;
import java.util.*;

// BJ #11660 - 구간 합 구하기 5
// Strategy: DP
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sums = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int sum = 0;
        	for(int j=1; j<=N; j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		if(i == 0) {	
        			sums[i][j] = sums[i][j-1] + tmp;
        		}else {
        			sums[i][j] = sums[i-1][j] + sum + tmp;
        		}
        		sum += tmp;
        	}
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	sb.append(sums[x2][y2] - sums[x2][y1-1] - sums[x1-1][y2] + sums[x1-1][y1-1]).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}