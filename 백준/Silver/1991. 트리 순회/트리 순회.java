import java.io.*;
import java.util.*;

// BJ #1991 - 트리 순회
// Strategy: 
public class Main {
	static StringBuilder sb;
	static Node[] tree;
	
	public static class Node{
		char value;
		char left;
		char right;
		
		public Node(char value, char left, char right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	public static void preorder(Node n) {
		sb.append(n.value);
		if(n.left != '.') {
			preorder(tree[n.left-'A']);
		}
		if(n.right != '.') {
			preorder(tree[n.right-'A']);
		}
	}
	
	public static void inorder(Node n) {
		if(n.left != '.') {
			inorder(tree[n.left-'A']);
		}
		sb.append(n.value);
		if(n.right != '.') {
			inorder(tree[n.right-'A']);
		}
	}
	
	public static void postorder(Node n) {
		if(n.left != '.') {
			postorder(tree[n.left-'A']);
		}
		if(n.right != '.') {
			postorder(tree[n.right-'A']);
		}
		sb.append(n.value);
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        tree = new Node[N];
        
        // node 정보 저장
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	char tmp = st.nextToken().charAt(0);
        	char tmp_left = st.nextToken().charAt(0);
        	char tmp_right = st.nextToken().charAt(0);
        	
        	tree[tmp-'A'] = new Node(tmp, tmp_left, tmp_right);
        }
        
        // 트리 순회 결과 저장
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}