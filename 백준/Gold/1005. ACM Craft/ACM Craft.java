import java.util.*;
import java.io.*;

// BJ #1005 - ACM Craft
// Strategy: 위상정렬(Topological Sorting)

public class Main {
	static int N, K, W, time;
	static int[] D, inDegree;
	static List<List<Integer>> graph;
	
	// 위상정렬
	public static void TS() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] res = new int[N+1];
		
		// 진입 차수 0인 노드를 큐에 넣기 + res 배열 초기화
		for(int i=1; i<=N; i++) {
			res[i] = D[i];
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int n : graph.get(tmp)) {
				res[n] = Math.max(res[n], res[tmp] + D[n]);
				inDegree[n]--;
				if(inDegree[n] == 0) q.add(n);
			}
		}
		
		// 건물 W를 지을 때까지 걸리는 최소시간 저장
		time = res[W];
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 건물 건설에 걸리는 시간 입력
			D = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			// 그래프 정보 입력 + 진입 차수 저장
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			inDegree = new int[N+1];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				graph.get(X).add(Y);
				inDegree[Y]++;
			}
			
			// 목표 건물
			W = Integer.parseInt(br.readLine());
			
			// 현재 테스트케이스 결과 저장
			time = 0;
			TS();
			sb.append(time).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
