import java.util.*;
import java.io.*;

// SWEA #1223 - 계산기2
// Strategy: Stack
class Solution {
	// isp(c): c의 in-stack priority 반환
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
	
	// icp(c): c의 in-coming priority 반환
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
        
        
        for(int t=1; t<11; t++) {
        	int len = Integer.parseInt(br.readLine());		// 수식의 길이
        	
        	String formula = br.readLine();			// 수식이 저장되는 문자열
            Stack<Character> ops = new Stack<>();	// 연산자를 저장하는 스택
            StringBuilder formula_back = new StringBuilder();  // 후위 표기법으로 변환한 수식 저장
            
            // 후위표기법 변환
            for(int i=0; i<len; i++) {	// 글자수만큼 반복
            	char tmp = formula.charAt(i);		// 현재 글자
            	
            	if(tmp >= 48 && tmp <= 57) {	// 현재 글자가 피연산자
            		formula_back.append(tmp);
            	
            	}else if(tmp == ')') {			// 현재 글자가 닫는 괄호일 경우
            		
            		while(!ops.isEmpty()) {		// 여는 괄호를 만날때까지 스택에서 pop한후 출력, 여는 괄호를 만나면 출력은 x
            			if(ops.peek() == '(') {
            				ops.pop();
            				break;
            			}
            			formula_back.append(ops.pop());
            		}
            	
            	}else {							// 현재 글자가 닫는 괄호가 아닌 연산자인 경우
            		
            		if(ops.isEmpty() || icp(tmp) > isp(ops.peek())) {	// 스택이 비어있거나, 현재 연산자가 스택의 맨 위에 있는 연산자보다 우선순위가 클 경우
            			ops.add(tmp);
            		}else {						// 현재 연산자의 우선순위가 스택의 맨위 연산자의 우선순위와 같거나 작을 경우
            			while(!ops.isEmpty() && icp(tmp) <= isp(ops.peek())) {	// 스택이 비거나, 우선순위가 커질때까지 스택에서 pop한 후 출력
                			formula_back.append(ops.pop());
                		}
            			ops.push(tmp);			// 현재 연산자 push
            		}
            	}
            }
            while(!ops.isEmpty()) {				// 모든 글자에 대한 과정을 수행한 후 스택에 연산자가 남아있다면 pop 후 출력(스택이 빌 때까지)
    			formula_back.append(ops.pop());
    		}
            //
            
            
            // 후위 표기법 식을 읽어 계산
            Stack<Integer> nums = new Stack<>();
            
            for(int i=0; i<formula_back.length(); i++) {
            	char tmp = formula_back.charAt(i);
            	if(tmp >= 48 && tmp <= 57) {
            		nums.add(tmp-48);
            	}else {
            		int b = nums.pop();
            		int a = nums.pop();
            		if(tmp == '+') {
            			nums.add(a+b);
            		}else if(tmp == '-') {
            			nums.add(a-b);
            		}else if(tmp == '*') {
            			nums.add(a*b);
            		}else if(tmp == '/') {
            			nums.add(a/b);
            		}
            	}
            }
            
            sb.append("#"+t).append(" ").append(nums.pop()).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}