import java.util.*;
import java.io.*;

// SWEA #6057 - 그래프의 삼각형
// Strategy: 

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	boolean[][] graph = new boolean[N+1][N+1];
        	for(int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		graph[x][y] = true;
        		graph[y][x] = true;
        	}
        	
        	int res = 0;
        	for(int i=1; i<=N-2; i++) {
        		for(int j=i+1; j<=N-1; j++) {
        			for(int k=j+1; k<=N; k++) {
        				if(graph[i][j] && graph[j][k] && graph[k][i]) {
        					res++;
        				}
        			}
        		}
        	}
        	
        	sb.append("#"+t).append(" ").append(res).append("\n");
        }
        
        System.out.println(sb);
    }
}