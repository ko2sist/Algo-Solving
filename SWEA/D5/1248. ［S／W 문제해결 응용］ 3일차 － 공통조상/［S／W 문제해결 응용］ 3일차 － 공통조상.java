import java.util.*;
import java.io.*;

// SWEA #1248 - 공통조상
// Strategy : tree 
public class Solution {
	static int[][] tree;
	
	// find(v1,v2,V): V개의 정점 중 v1,v2의 공통조상의 번호 반환
	public static int find(int v1, int v2, int V) {
		boolean[] visited = new boolean[V+1];
		int res = 0;
		
		int cur = v1;
		while(true) {
			visited[cur] = true;
			
			if(cur == 1) {
				break;
			}
			
			cur = tree[cur][2];
		}
		
		cur = v2;
		while(true) {
			if(visited[cur]) {
				res = cur;
				break;
			}
			
			cur = tree[cur][2];
		}
		
		
		return res;
	}
	
	// cal(n): n을 root로 하는 subtree의 크기 반환
	public static int cal(int n) {
		int res = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tree[tmp][0] != 0) {
				q.add(tree[tmp][0]);
				res++;
			}
			
			if(tree[tmp][1] != 0) {
				q.add(tree[tmp][1]);
				res++;
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// T: 테스트케이스 수
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// Tree 정보, 공통 조상 탐색 대상 정점 번호 입력
			int V = Integer.parseInt(st.nextToken()); // V: 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // E: 간선의 개수
			int v1 = Integer.parseInt(st.nextToken()); // v1: 공통 조상을 찾는 정점 번호
			int v2 = Integer.parseInt(st.nextToken()); // v2: 공통 조상을 찾는 정점 번호

			// tree: 정점, 간선 정보를 저장할 2차원 배열 (tree[n][0]애는 n의 왼쪽 자식, tree[n][1]엔 정점 n의 오른쪽 자식이 저장됨
			//		tree[n][2] 에는 n의 부모 저장)
			tree = new int[V + 1][3];

			// 간선 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				if (tree[parent][0] == 0) { // parent 정점에 현재 왼쪽 자식이 없을 경우 -> 왼쪽 자식에 저장
					tree[parent][0] = child;
				} else { 					// parent 정점에 현재 왼쪽 자식이 있을 경우 -> 오른쪽 자식에 저장
					tree[parent][1] = child;
				}
				tree[child][2] = parent;	// child에 부모 정보 저장
			}

			// 공통 조상 찾기
			int res_node = find(v1, v2, V);
			int res_num = cal(res_node);

			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ");
			sb.append(res_node).append(" ").append(res_num).append("\n");
		}

		// 최종 결과 출력
		System.out.println(sb);
	}
}
