import java.io.*;
import java.util.*;

// BJ #11725 - 트리의 부모 찾기
// Strategy: BFS
public class Main {
	static List<List<Integer>> edge;
	static int N;
	static int[] num_parent;
	
	public static void parent() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			List<Integer> tmp_list = edge.get(tmp);
			
			for(int i=0; i<tmp_list.size(); i++) {
				int tn = tmp_list.get(i);
				if(visited[tn]) continue;
				
				q.add(tn);
				visited[tn] = true;
				num_parent[tn] = tmp;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		edge = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			edge.add(new ArrayList<Integer>());
		}
		num_parent = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edge.get(n1).add(n2);
			edge.get(n2).add(n1);
		}
		
		// BFS 실행
		parent();
		
		// 결과 저장
		for(int i=2; i<=N; i++) {
			sb.append(num_parent[i]).append("\n");
		}
		
		// 최종 결과 출력
		System.out.print(sb);
	}
}