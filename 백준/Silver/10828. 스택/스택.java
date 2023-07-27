import java.io.*;
import java.util.*;

// BJ #10866
public class Main {
    public static class MyStack{
    	private final int MAX_SIZE=10000;
    	private int[] ints = new int[MAX_SIZE];
    	private int l_idx;
    	
    	public MyStack() {}
    	
    	public void push(int X) {
    		ints[l_idx++] = X;
    	}
    	
    	public int pop() {
    		if(this.empty() == 0) {
    			return ints[--l_idx];
    		}else {
    			return -1;
    		}
    	}
    	
    	public int size() {
    		return l_idx;
    	}
    	
    	public int empty() {
    		if(this.size() == 0) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	
    	public int top() {
    		if(this.empty() == 0) {
    			return ints[l_idx-1];
    		}else {
    			return -1;
    		}
    	}
    }
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        MyStack s = new MyStack();
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	if(str.equals("pop")) {
        		sb.append(s.pop()).append("\n");
        	}else if(str.equals("size")) {
        		sb.append(s.size()).append("\n");
        	}else if(str.equals("empty")) {
        		sb.append(s.empty()).append("\n");
        	}else if(str.equals("top")) {
        		sb.append(s.top()).append("\n");
        	}else {
        		StringTokenizer st = new StringTokenizer(str);
        		String cmd = st.nextToken();
        		int n = Integer.parseInt(st.nextToken());
        		s.push(n);
        	}
        }
        
        System.out.println(sb);
    }
}