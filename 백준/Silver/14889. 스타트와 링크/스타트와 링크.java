import java.util.*;
import java.io.*;

// BJ #14889 - 스타트와 링크
// Strategy: 백트래킹
public class Main {
	static int N, max_len, min;
	static int[][] S;
	
	public static int cal(int[] teamA, int[] teamB) {
		int sa = 0;
		int sb = 0;
		
		for(int i=0; i<max_len; i++) {
			for(int j=0; j<max_len; j++) {
				sa += S[teamA[i]-1][teamA[j]-1];
			}
		}
		
		for(int i=0; i<max_len; i++) {
			for(int j=0; j<max_len; j++) {
				sb += S[teamB[i]-1][teamB[j]-1];
			}
		}
		
		return Math.abs(sa-sb);
	}
	
	public static void back(int len, int[] teamA, boolean[] visited) {
		if(len == max_len) {
			int[] teamB = new int[max_len];
			int idx = 0;
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					teamB[idx] = i;
					idx++;
				}
			}
			
			int d = cal(teamA, teamB);
			
			if(d < min) min = d;
			return;
		}
		
		for(int i=teamA[len-1]; i<=N; i++) {
			if(!visited[i]) {
				teamA[len] = i;
				visited[i] = true;
				back(len+1, teamA, visited);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		max_len = N/2;
		
		S = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		int[] teamA = new int[max_len];
		teamA[0] = 1;
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		back(1, teamA, visited);
		
		System.out.println(min);
	}
}
