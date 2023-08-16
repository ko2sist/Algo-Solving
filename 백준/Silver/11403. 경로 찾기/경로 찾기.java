import java.io.*;
import java.util.*;

// BJ #11403 - 경로 찾기
// Strategy: BFS
public class Main {
	static int N;
	static int[][] graph;
	
	public static boolean[] BFS(int v) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		return visited;
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        
        // 그래프 정보 입력
        for(int i=1; i<N+1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<N+1; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=1; i<N+1; i++) {
        	boolean[] tmp = BFS(i);
        	for(int j=1; j<N+1; j++) {
        		if(tmp[j]) {
        			sb.append(1).append(" ");
        		}else {
        			sb.append(0).append(" ");
        		}
        	}
        	sb.append("\n");
        }
       
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}