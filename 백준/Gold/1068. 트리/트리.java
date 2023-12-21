import java.util.*;
import java.io.*;


// BJ #1068 - 트리
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 노드 개수
		int N = Integer.parseInt(br.readLine());
		
		// 그래프(트리) 초기화
		List<Integer>[] graph = new ArrayList[N];		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		// 그래프(트리) 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for(int i=0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			if(p == -1) {
				root = i;
				continue;
			}
			
			graph[p].add(i);
		}
		
		// 지울 노드 번호
		int remove = Integer.parseInt(br.readLine());
		
		// DFS를 통한 리프 노드 개수 구하기
		int result = 0;
		
		Stack<Integer> s = new Stack<>();
//		boolean[] visited = new boolean[N];

		s.add(root);
//		visited[root] = true;
		
		while(!s.isEmpty()) {
			int tmp = s.pop();
			
			if(tmp == remove) continue;
			
			int c = 0;
			
			for(int v : graph[tmp]) {
				if(v == remove) continue;
				s.add(v);
				c++;
			}
			
			if(c == 0) result++;
		}
		
		System.out.println(result);
		
		
	}
}
