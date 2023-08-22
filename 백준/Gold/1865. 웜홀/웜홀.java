import java.util.*;
import java.io.*;

// BJ #1865 - 웜홀
// Strategy: Bellman-Ford (음수 사이클 판정)
public class Main {
	static int INF = (int)1e9;
	static int N;
	
	public static boolean Bellman(int[][] graph) {
		int[] dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			dist[i] = INF;
		}
		
		dist[1] = 0;
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(graph[i][j] != 0) {	// edge에 대해
						if(dist[j] > dist[i] + graph[i][j]) {
							dist[j] = dist[i] + graph[i][j];
							if(k == N) {	// 음수 사이클 존재
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            int[][] graph = new int[N+1][N+1];
            
            // 도로 정보 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                if(graph[S][E] == 0 || T < graph[S][E]) {
                    graph[S][E] = T;
                    graph[E][S] = T;
                }
            }

            // 웜홀 정보 입력
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                graph[S][E] = -T;
            }
            
            if(Bellman(graph)) {	// 음수 사이클이 존재할 경우
            	sb.append("YES").append("\n");
            }else {					// 음수 사이클 미존재
            	sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }
}