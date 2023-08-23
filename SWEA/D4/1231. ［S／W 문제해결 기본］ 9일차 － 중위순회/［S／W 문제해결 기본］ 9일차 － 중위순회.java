import java.util.*;
import java.io.*;

// SWEA #1231 - 중위순회
// Strategy : tree
public class Solution {
	static StringBuilder sb;
	static Node[] arr;
	
	// Node: tree의 node 정보를 저장하는 class
	public static class Node{
		String v;
		int left;
		int right;
		
		public Node(String v, int left, int right) {
			this.v = v;
			this.left = left;
			this.right = right;
		}
	}
	
	// inorder: 중위순회 method
	public static void inorder(int n) {
		Node tmp = arr[n];
		
		if(tmp.left != 0) inorder(tmp.left);
		sb.append(tmp.v);
		if(tmp.right != 0) inorder(tmp.right);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			// Node 정보를 저장하는 배열
			arr = new Node[N+1];
			
			// Node 정보 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int left = 0;
				int right = 0;
				
				int parent = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}
				
				if(st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}
				
				// Node 정보 배열에 저장
				arr[parent] = new Node(value, left, right);
			}
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#").append(t).append(" ");
			inorder(1);
			sb.append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
