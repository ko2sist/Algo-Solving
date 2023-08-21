import java.util.*;
import java.io.*;

// BJ #1167 - 트리의 지름
// Strategy:  DFS
public class Main {
	static int n;
	static List<List<Edge>> graph;
	
	public static class Node{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	
	public static class Edge{
		int dest;
		int weight;
		
		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static int[] DFS(int node) {
		Stack<Node> s = new Stack<>();
		boolean[] visited = new boolean[n+1];
		
		int max_weight = 0;
		int max_node = 0;
		
		s.add(new Node(node, 0));
		
		while(!s.isEmpty()) {
			Node tmp = s.pop();
			List<Edge> tmp_list = graph.get(tmp.num);
			visited[tmp.num] = true;
			if(tmp.weight > max_weight) {
				max_node = tmp.num;
				max_weight = tmp.weight;
			}
			
			for(Edge e : tmp_list) {
				if(!visited[e.dest]) {
					s.add(new Node(e.dest, tmp.weight+e.weight));
				}
			}
		}
		
		return new int[] {max_node, max_weight};
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			while(true) {
				int child = Integer.parseInt(st.nextToken());
				if(child == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				
				graph.get(parent).add(new Edge(child, weight));
				graph.get(child).add(new Edge(parent, weight));
			}	
		}
		
		int[] res1 = DFS(1);
		int[] res2 = DFS(res1[0]);
		System.out.println(res2[1]);
	}
}
