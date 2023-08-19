import java.io.*;
import java.util.*;

// BJ #9465 - 스티커
// Strategy: DP
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	// 열 개수 입력
        	int N = Integer.parseInt(br.readLine());
        	
        	// 스티커 별 점수 입력
        	int[][] point = new int[2][N];
        	for(int i=0; i<2; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			point[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 단계별 점수 합 계산 by DP
        	int[][] res = new int[2][N];
        	res[0][0] = point[0][0];
        	res[1][0] = point[1][0];
        	if(N>=2) {
        		res[0][1] = res[1][0] + point[0][1];
            	res[1][1] = res[0][0] + point[1][1];
        	}
        	
        	for(int i=2; i<N; i++) {
        		res[0][i] = Math.max(res[1][i-1], res[1][i-2]) + point[0][i];
        		res[1][i] = Math.max(res[0][i-1], res[0][i-2]) + point[1][i];
        	}
        	
        	// 결과 저장
        	sb.append(Math.max(res[0][N-1], res[1][N-1])).append("\n");
        }
        // 최종 결과 출력
        System.out.print(sb);
    }
}