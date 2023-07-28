import java.io.*;
import java.util.*;

// BJ #4949
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        
        loop1: while(true) {
        	String s = br.readLine();
        	Stack<Character> st = new Stack<>();
        	if(s.equals(".")) {
        		break loop1;
        	}
        	for(int i=0; i<s.length(); i++) {
        		char tmp = s.charAt(i);
        		if(tmp == '(' || tmp == '[') {
        			st.push(tmp);
        		}else if(tmp == ')') {
        			
        			if(st.isEmpty() || st.pop() != '(') {
        				sb.append("no\n");
        				continue loop1;
        			}
        		}else if(tmp == ']') {
        			if(st.isEmpty() || st.pop() != '[') {
        				sb.append("no\n");
        				continue loop1;
        			}
        		}else {
        			continue;
        		}
        	}
        	if(st.isEmpty()) {
        		sb.append("yes\n");
        	}else {
        		sb.append("no\n");
        	}
        }
           
        System.out.println(sb);
    }
}