import java.util.*;
import java.io.*;

// BJ #1766 - 문제집
// Strategy: 위상정렬

public class Main {
	static int N,M;
	static List<List<Integer>> graph;
	static int[] indegree;
	static StringBuilder sb;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			indegree[B]++;
		}

		
		TS();

		
		System.out.println(sb);
		
	}

	public static void TS() {
		pq = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(pq.isEmpty()) return;
			
			int n = pq.poll();
			sb.append(n).append(" ");
			
			for(int v : graph.get(n)) {
				indegree[v]--;
				if(indegree[v] == 0) {
					pq.add(v);
				}
			}
		}
	}
}