import java.util.*;
import java.io.*;

// BJ #6549 - 히스토그램에서 가장 큰 직사각형
// Strategy: Segment Tree
public class Main {
	static int N;
	static long max;
	static int[] height, tree;
	
	public static void makeST(int start, int end, int node) {
		if(start == end) {
			 tree[node] = start;
			 return;
		}
		
		int mid = (start+end)/2;
		
		makeST(start, mid, node*2);
		makeST(mid+1, end, node*2+1);
		if(height[tree[node*2]] > height[tree[node*2+1]]) {
			tree[node] = tree[node*2+1];
		}else {
			tree[node] = tree[node*2];
		}
		return;
	}
	
	public static int interval_min(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return -1;
		
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int idx1 = interval_min(start,mid,node*2,left,right);
		int idx2 = interval_min(mid+1,end,node*2+1,left,right);
		
		if(idx2 == -1) {
			return idx1;
		}else if(idx1 == -1) {
			return idx2;
		}else {
			if(height[idx1] <= height[idx2]) {
				return idx1;
			}else {
				return idx2;
			}
		}
	}
	
	public static void getMax(int left, int right) {
		int minIdx = interval_min(0, N-1, 1, left, right);
		
		long res = (long)(right-left+1) * (long)height[minIdx];
		if(res > max) max = res;
		
		if(minIdx+1 <= right) {
			getMax(minIdx+1, right);
		}
		
		if(minIdx-1 >= left) {
			getMax(left, minIdx-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) {
				break;
			}
			
			height = new int[N];
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			tree = new int[N*4];
			
			makeST(0, N-1, 1);
			

			max = Long.MIN_VALUE;
			
			getMax(0, N-1);
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
