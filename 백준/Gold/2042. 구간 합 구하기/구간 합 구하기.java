import java.util.*;
import java.io.*;

// BJ #2042 - 구간 합 구하기
// Strategy: Segment Tree
public class Main {
	static int N;
	static long max;
	static long[] arr, tree;
	
	public static long makeST(int start, int end, int node) {
		if(start == end) {
			 tree[node] = arr[start];
			 return tree[node];
		}
		
		int mid = (start+end)/2;
		
		return tree[node] = makeST(start, mid, node*2) + makeST(mid+1, end, node*2+1);
	}
	
	public static long interval_sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;
		
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		
		return interval_sum(start,mid,node*2,left,right)+interval_sum(mid+1,end,node*2+1,left,right);
	}
	
	public static void update(int start, int end, int node, int idx, long val) {		
		if(start == end) {
			tree[node] = val;
			return;
		}
		int mid = (start+end)/2;
		
		if(start <= idx && idx <= mid) {
			update(start, mid, node*2, idx, val);
		}else {
			update(mid+1, end, node*2+1, idx, val);
		}
		tree[node] = tree[node*2] + tree[node*2+1];
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[N*4];
		        
		makeST(0, N-1, 1);
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(0,N-1,1,b-1, c);
			}else {
				sb.append(interval_sum(0, N-1, 1, b-1, (int)c-1)).append("\n");
			}
		}
			
		System.out.println(sb);
	}
}
