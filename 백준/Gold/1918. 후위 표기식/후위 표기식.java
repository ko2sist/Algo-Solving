import java.io.*;
import java.util.*;

// BJ #1918 - 중위 표기식
// Strategy: Stack
public class Main {
	public static int isp(char c) {
		if(c == '*' || c == '/') {
			return 2;
		}else if(c == '+' || c == '-') {
			return 1;
		}else if(c == '(') {
			return 0;
		}
		return 0;
	}
	public static int icp(char c) {
		if(c == '*' || c == '/') {
			return 2;
		}else if(c == '+' || c == '-') {
			return 1;
		}else if(c == '('){
			return 3;
		}
		return 0;
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String formula = br.readLine();
        Stack<Character> ops = new Stack<>();
        
        for(int i=0; i<formula.length(); i++) {
        	char tmp = formula.charAt(i);
        	
        	if(tmp >= 65 && tmp <= 90) {	// 현재 글자가 피연산자
        		sb.append(tmp);
        	}else if(tmp == ')') {	
        		
        		while(!ops.isEmpty()) {
        			if(ops.peek() == '(') {
        				ops.pop();
        				break;
        			}
        			sb.append(ops.pop());
        		}
        	}else {				
        		if(ops.isEmpty() || icp(tmp) > isp(ops.peek())) {
        			ops.add(tmp);
        		}else {
        			while(!ops.isEmpty() && icp(tmp) <= isp(ops.peek())) {
            			sb.append(ops.pop());
            		}
        			ops.push(tmp);
        		}
        	}
        }
        while(!ops.isEmpty()) {
			sb.append(ops.pop());
		}
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}