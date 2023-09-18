import java.util.*;
import java.io.*;

// BJ #9935 - 문자열 폭발
// Strategy: Stack

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String pat = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
        	char tmp = str.charAt(i);
        	stack.add(tmp);
        	
        	if(stack.size() >= pat.length()) {
        		boolean check = true;
        		for(int j=0; j<pat.length(); j++) {
        			if(stack.get(stack.size()-pat.length()+j) != pat.charAt(j)) {
        				check = false;
        				break;
        			}
        		}
        		
        		if(check) {
        			for(int j=0; j<pat.length(); j++) {
        				stack.pop();
        			}
        		}
        	}
        }
        
        // 최종 결과 출력
        for(char c : stack) {
        	sb.append(c);
        }
        
        if(sb.length() == 0) {
        	System.out.println("FRULA");
        }else {
        	 System.out.println(sb);
        }
       
    }
}