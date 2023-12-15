import java.util.*;
import java.io.*;

// BJ #15591 - Mootube
// Strategy: 

public class Main {
	static int N,Q;
	static List<int[]>[] graph;
	
	public static int bfs(int n, int k) {
		int result = 0;

		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		visited[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int[] e : graph[tmp]) {
				if(!visited[e[0]] && e[1] >= k) {
					q.add(e[0]);
					visited[e[0]] = true;
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int p = Integer.parseInt(st.nextToken());
        	int q = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	
        	graph[p].add(new int[] {q,r});
        	graph[q].add(new int[] {p,r});
        }
        
        for(int i=0; i<Q; i++) {
        	st = new StringTokenizer(br.readLine());
        	int k = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());

        	sb.append(bfs(v,k)).append("\n");
        }
        
        System.out.println(sb);
	}
}