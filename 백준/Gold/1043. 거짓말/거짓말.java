import java.util.*;
import java.io.*;

// BJ #1043 - 거짓말
// Strategy: Union-Find

public class Main {
	static int[] parent;
//	static int[] rank;
	static List<Integer> truth;
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
				
		if(truth.contains(y)) {
			parent[x] = y;
			return;
		}
		
		parent[y] = x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// Union-find를 위한 parent 생성 및 초기화
		parent = new int[N+1];
//		rank = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		// 진실을 아는 사람의 정보 입력
		st = new StringTokenizer(br.readLine());
		int tn = Integer.parseInt(st.nextToken());
		truth = new ArrayList<>();
		for(int i=0; i<tn; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			truth.add(tmp);
		}
		
		
		// 파티 정보 입력, union 과정 진행
		int[] party = new int[M];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			party[i] = x;
			for(int j=1; j<p; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
			}
		}
		
		// 결과 계산
		int res = 0;
		for(int i=0; i<M; i++) {
			if(truth.contains(find(party[i]))) {
				continue;
			}
			res++;
		}
		
		// 최종 결과 출력
		System.out.println(res);
	}
}