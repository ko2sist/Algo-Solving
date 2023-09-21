import java.util.*;
import java.io.*;

// BJ #16566 - 카드게임
// Strategy: 이분탐색, union-find


public class Main {
	static int N,M;
	static int[] parent, rank;
	
	// Union-Find
	public static void makeSet() {
		parent = new int[M];
		rank = new int[M];
		
		for(int i=0; i<M; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}	
	
	public static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		
		// parent를 찾아낸 루트로 바꾸면 find 연산 수행시 중복되는 연산을 줄여줌
		// 재귀적인 구현 덕분에 u에서 root까지 올라가는 경로상에 있는 모든 노드들에 대해서도
		// 경로 압축 최적화가 자동으로 수행된다.
		parent[u] = find(parent[u]);
		return parent[u];
	}
	
	public static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) return;
		
//		if(rank[u] > rank[v]) {
//			// swap
//			int tmp = u;
//			u = v;
//			v = tmp;
//		}
		
		parent[u] = v;
		
//		if(rank[u] == rank[v]) rank[v]++;
	}	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[M];
		for(int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		// 분리집합을 위한 makeSet
		makeSet();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int key = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = M-1;
			
			
			while(start < end) {
				int mid = (start+end) >> 1 ;
				
				if(key < nums[mid]) {
					end = mid;
				}else {
					start = mid + 1;
				}
					
			}

			int idx = find(start);
			System.out.println(nums[idx]);
			if(idx<M-1) {
				union(idx, idx+1);
			}

		}
		
		System.out.println(sb);
	}
}