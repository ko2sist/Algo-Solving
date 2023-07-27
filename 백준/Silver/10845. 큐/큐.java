import java.io.*;
import java.util.*;

// BJ #10845
public class Main {
	public static class MyQueue{
		private final int MAX_SIZE = 10000;
		
		private int[] ints = new int[MAX_SIZE];
		
		private int f_idx;
		private int l_idx;
		
		public void push(int X) {
			ints[l_idx++] = X;
		}
		
		public int pop() {
			if(this.empty()==0) {
				return ints[f_idx++];
			}else {
				return -1;
			}
		}
		
		public int size() {
			return l_idx-f_idx;
		}
		
		public int empty() {
			if (this.size() == 0) {
				return 1;
			}else {
				return 0;
			}
		}
		
		public int front() {
			if(this.empty()==1) {
				return -1;
			}else {
				return ints[f_idx];
			}
		}
		
		public int back() {
			if(this.empty()==1) {
				return -1;
			}else {
				return ints[l_idx-1];
			}
		}
	}
    public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue();
        
        for(int i=0; i<N; i++) {
        	String tmp = br.readLine();
        	if(tmp.equals("pop")){
        		sb.append(q.pop()).append("\n");
        	}else if(tmp.equals("size")) {
        		sb.append(q.size()).append("\n");
        	}else if(tmp.equals("empty")) {
        		sb.append(q.empty()).append("\n");
        	}else if(tmp.equals("front")) {
        		sb.append(q.front()).append("\n");
        	}else if(tmp.equals("back")) {
        		sb.append(q.back()).append("\n");
        	}else {
        		StringTokenizer st = new StringTokenizer(tmp);
        		String cmd = st.nextToken();
        		int n = Integer.parseInt(st.nextToken());
        		q.push(n);
        	}
        }
        System.out.println(sb);
    }
}