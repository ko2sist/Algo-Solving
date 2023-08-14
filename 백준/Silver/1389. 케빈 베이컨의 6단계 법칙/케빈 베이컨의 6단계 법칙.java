import java.util.*;
import java.io.*;

// BJ #1389 - 케빈 베이컨의 6단계 법칙
// Strategy: BFS
public class Main {
	static int N,M;
	static List<List<Integer>> graph;
	
	public static int BFS(int v) {
		int res = 0;
		int depth = 1;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				int tmp = q.poll();
				
				for(int node: graph.get(tmp)) {
					if(visited[node]) continue;
					
					q.add(node);
					visited[node] = true;
					res += depth;
				}
			}
			depth++;
		}
		return res;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			graph.get(B).add(A);
		}
		
		int min = Integer.MAX_VALUE;
		int min_idx = 0;
		for(int i=1; i<N+1; i++) {
			int tmp = BFS(i);
			if(min > tmp) {
				min = tmp;
				min_idx = i;
			}
		}

		// 최종 결과 출력
		System.out.println(min_idx);
	}
}
