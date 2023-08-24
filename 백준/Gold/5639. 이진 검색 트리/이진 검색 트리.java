import java.util.*;
import java.io.*;

// BJ #5639 - 이진 검색 트리
// Strategy: 
public class Main {
	static StringBuilder sb;
	
	public static class Node{
		int n;
		Node left;
		Node right;
		
		public Node(int n) {
			this.n = n;
			left = null;
			right = null;
		}
		
		public void setLeft(Node node) {
			left = node;
		}
		
		public void setRight(Node node) {
			right = node;
		}
	}
	
	public static class BinaryTree{
		Node root;
		
		public BinaryTree() {
			root = null;
		}
		
		public void setRoot(Node node) {
			root = node;
		}
		
		public void add(int n) {
			if(root == null) {
				root = new Node(n);
				return;
			}
			
			Node tmp = root;
			while(true) {
				int tn = tmp.n;
				if(n < tn) {
					if(tmp.left == null) {
						tmp.left = new Node(n);
						return;
					}else {
						tmp = tmp.left;
					}
				}else {
					if(tmp.right == null) {
						tmp.right = new Node(n);
						return;
					}else {
						tmp = tmp.right;
					}
				}
			}
			
		}
		
		public void postorder(Node node) {
			if(node.left != null) {
				postorder(node.left);
			}
			if(node.right != null) {
				postorder(node.right);
			}
			sb.append(node.n).append("\n");
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String input = "";
		BinaryTree BT = new BinaryTree();
		

		while((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			BT.add(n);
		}
		
		BT.postorder(BT.root);
		
		System.out.println(sb);
	}
}