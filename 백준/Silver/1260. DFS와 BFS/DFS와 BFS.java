import java.io.*;
import java.util.*;

// BJ #1260 - DFS와 BFS
// Strategy: Graph
public class Main {
	static int[][] graph;  // graph 정보를 저장할 2차원 배열
	static int N,M,V;	// N: 정점 개수, M: 간선 개수, V: 시작 정점 번호
	static StringBuilder sb = new StringBuilder();  // 결과 출력을 위한 SB
	
	public static void DFS(int v) {
		boolean[] visited = new boolean[N+1];
		Stack<Integer> s = new Stack<>();
		
		s.push(v);
		
		while(!s.isEmpty()) {
			int tmp = s.pop();
			if(visited[tmp]) {
				continue;
			}
			visited[tmp] = true;
			
			sb.append(tmp).append(" ");
			for(int i=N; i>=0; i--) {
				if(graph[tmp][i] == 1 && !visited[i]) {
					s.push(i);
				}
			}
		}
		sb.append("\n");
	}
	
	public static void BFS(int v) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp).append(" ");
			
			for(int i=1; i<N+1; i++) {
				if(graph[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N,M,V 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
       
        // 그래프 초기화
        graph = new int[N+1][N+1];
     
        
        // 간선 정보 입력
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	
        	graph[v1][v2] = 1;
        	graph[v2][v1] = 1;
        }
        
        // DFS, BFS 실행
        DFS(V);
        BFS(V);
        
        // 최종 결과 출력
        System.out.println(sb);

    }
}