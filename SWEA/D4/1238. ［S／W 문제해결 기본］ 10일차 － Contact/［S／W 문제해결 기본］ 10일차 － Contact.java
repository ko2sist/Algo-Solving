import java.util.*;
import java.io.*;

// SWEA #1238 - Contact
// Strategy: BFS

public class Solution {
	static List<List<Integer>> graph;
	static List<List<Integer>> res;
	static int depth;
	
	public static void BFS(int n) {
		boolean[] visited = new boolean[101];
		Queue<Integer> q = new ArrayDeque<>();
		res = new ArrayList<>();	// depth 별로 방문한 node 번호 저장
		depth = 0;					// depth
		
		q.add(n);
		visited[n] = true;
		res.add(new ArrayList<>());
		res.get(depth).add(n);
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			res.add(new ArrayList<>());
			
			while(size-- > 0) {
				int tmp = q.poll();
				
				for(int v : graph.get(tmp)) {
					if(!visited[v]) {
						q.add(v);
						res.get(depth).add(v);
						visited[v] = true;
					}
				}
			}

		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // T: 테스트 케이스 개수
        int T = 10;
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int L = Integer.parseInt(st.nextToken());	// 데이터 길이
        	int S = Integer.parseInt(st.nextToken());	// 시작점
        	
        	// 그래프 초기화
        	graph = new ArrayList<>();
        	for(int i=0; i<=101; i++) {
        		graph.add(new ArrayList<>());
        	}
        	
        	// 그래프 입력
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<L/2; i++) {
        		int v = Integer.parseInt(st.nextToken());
        		int w = Integer.parseInt(st.nextToken());
        		
        		graph.get(v).add(w);
        	}
        	
        	// BFS 실행
        	BFS(S);
        	
        	// 마지막에 방문한 node들중 가장 큰 번호 찾기
        	List<Integer> check = res.get(depth-1);
        	int max = 0;
        	for(int c : check) {
        		if(c > max) max = c;
        	}
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ").append(max).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}