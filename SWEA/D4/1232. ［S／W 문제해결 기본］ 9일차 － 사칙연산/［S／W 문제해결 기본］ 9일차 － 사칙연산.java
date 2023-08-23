import java.util.*;
import java.io.*;

// SWEA #1232 - 사칙연산
// Strategy : tree (후위순회)
public class Solution {
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
	public static int inorder(int n) {
		Node tmp = arr[n];
		
		if(tmp.left != 0) {		// 현재 정점의 값이 연산자
			char op = tmp.v.charAt(0);
			int left = inorder(tmp.left);
			int right = inorder(tmp.right);
			
			if(op == '+') {				// 덧셈
				return left + right;
			}else if(op == '-') {		// 뺄셈
				return left - right;
			}else if(op == '*') {		// 곱셈
				return left * right;
			}else {						// 나눗셈
				return left / right;
			}
			
		}else {					// 현재 정점이 leaf
			return Integer.parseInt(tmp.v);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=1; t<=10; t++) {
			// N: 정점의 개수
			int N = Integer.parseInt(br.readLine());
			
			// Node 정보를 저장하는 배열
			arr = new Node[N+1];
			
			// Node 정보 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int left = 0;
				int right = 0;
				
				int num = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				char op = value.charAt(0);
				
				if(op < 48 || op > 57) {	// 현재 Node에 연산자가 입력되는 경우
					left = Integer.parseInt(st.nextToken());
					right = Integer.parseInt(st.nextToken());
				}
				
				// Node 정보 배열에 저장
				arr[num] = new Node(value, left, right);
			}
			
			// 현재 테스트 케이스 결과 저장
			int res = inorder(1);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
