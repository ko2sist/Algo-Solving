import java.util.*;
import java.io.*;

// SWEA #18581 - 실습(이진트리 순회)
// Strategy : tree 
public class Solution {
	static int[][] tree;
	static StringBuilder sb;
	
	public static void preorder(int n) {
		sb.append(n).append(" ");
		if(tree[n][0] != 0) {
			preorder(tree[n][0]);
		}
		if(tree[n][1] != 0) {
			preorder(tree[n][1]);
		}
		
	}
	
	public static void inorder(int n) {
		if(tree[n][0] != 0) {
			inorder(tree[n][0]);
		}
		sb.append(n).append(" ");
		if(tree[n][1] != 0) {
			inorder(tree[n][1]);
		}
	}
	
	public static void postorder(int n) {
		if(tree[n][0] != 0) {
			postorder(tree[n][0]);
		}
		if(tree[n][1] != 0) {
			postorder(tree[n][1]);
		}
		sb.append(n).append(" ");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int V = Integer.parseInt(br.readLine());
		
		tree = new int[V+1][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<V-1; i++) {
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			if(tree[parent][0] == 0) {
				tree[parent][0] = child;
			}else {
				tree[parent][1] = child;
			}
		}
		
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
