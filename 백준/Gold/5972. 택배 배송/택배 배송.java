import java.util.*;
import java.io.*;

//pq를 활용한 다익스트라 알고리즘 풀이
public class Main {
	
	static int [] dist;
	static List<Node>[] adjList;
	
	//pq를 사용하려면 Comparable 사용하기
	public static class Node implements Comparable<Node>{
		
		int node;
		int cost;
		
		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// this 먼저, o 나중에 해야 오름차순
			return this.cost - o.cost;
		}
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//헛간
		int M = Integer.parseInt(st.nextToken());//소들의 길
		
		dist = new int[N+1]; //최단거리 저장할 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		adjList = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int A =  Integer.parseInt(st.nextToken());//시작 정점
			 int B =  Integer.parseInt(st.nextToken());//도착 정점
			 int C =  Integer.parseInt(st.nextToken());//가중치

			 //양방향 : 연결된 노드와 가중치 넣기
			 adjList[A].add(new Node(B,C));
			 adjList[B].add(new Node(A,C));
		}
		
		dijkstra(1);
		
		System.out.println(dist[N]);
	}
	public static void dijkstra(int startNode) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[startNode] = 0;
		
		pq.add(new Node(startNode, 0));//시작 노드의 정점 번호와 최소 거리(0)
		
		while(!pq.isEmpty()) {
			
			Node nextNode = pq.poll();
			
			//현재 정점과 연결된 정점들 하나씩 뽑기
			for(Node n : adjList[nextNode.node]) {
				if(dist[n.node] > dist[nextNode.node] + n.cost) {//기존의 최소 거리보다 새로 개선된 최소 거리가 짧다면 갱신
					dist[n.node] = dist[nextNode.node] + n.cost;
					pq.add(new Node(n.node, dist[n.node]));//pq에 선택된 노드와 해당 노드까지의 최소 거리 넣기(가중치 말고 최소거리 넣기)
				}
			}
		}
	}
}
