import java.io.*;
import java.util.*;

// BJ #11404 - 플로이드
// Strategy: Floyd-Warshall
public class Main {
	static int[][] graph, dist;
	static int N;
	static int INF = (int)1e9;
	
	public static void floyd() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) {
					dist[i][j] = 0;
				}else if(graph[i][j] != 0) {
					dist[i][j] = graph[i][j];
				}else {
					dist[i][j] = INF;
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {	
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        N = Integer.parseInt(br.readLine());	// N: 도시의 개수
        int M = Integer.parseInt(br.readLine());	// M: 버스의 개수
        
        graph = new int[N+1][N+1];
        
        for(int i=0; i<M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(graph[a][b] == 0 || graph[a][b] > c) {
        		graph[a][b] = c;
        	}
        }
        
        dist = new int[N+1][N+1];
        
        floyd();
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(dist[i][j] == INF) {
        			sb.append(0).append(" ");
        		}else {
        			sb.append(dist[i][j]).append(" ");
        		}
        		
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
}