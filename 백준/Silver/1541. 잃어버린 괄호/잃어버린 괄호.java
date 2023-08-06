import java.util.*;
import java.io.*;

// BJ #1541
// 전체적인 idea
// : -연산자들 사이에 나오는 식에 대해 괄호를 쳐서 큰 수를 빼는 것이
//   가장 작은 결과값을 얻을 수 있다.
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        // nums: 숫자 저장
        // ops: 연산자 저장
        String s = br.readLine();
        int len = s.length();
        Queue<Integer> nums = new LinkedList<>();
        Queue<String> ops = new LinkedList<>();
        
        // 입력 값을 분해해서 각각의 queue에 저장
        String tmp = "";
        for(int i=0; i<len; i++) {
        	char c = s.charAt(i);
        	if(c >= '0' && c <= '9') {
        		tmp += c;
        	}else {
        		nums.add(Integer.parseInt(tmp));
        		tmp = "";
        		if(c == '+') {
        			ops.add("+");
        		}else if(c == '-') {
        			ops.add("-");
        		}
        	}
        }
        nums.add(Integer.parseInt(tmp));

        
        // res: 결과값 저장
        // 1. res에 nums에서 처음 1개의 숫자를 뽑아 초기값으로 저장한다.
        // 2. 이후 숫자와 연산자를 하나씩 queue에서 뽑는다
        // 3. 뽑은 연산자가 -일 경우 지금까지 store에 저장된 값을 식에 -연산자가 존재하지 않았을 경우를
        //    고려해서 store에 저장된 값을 res에 더해주거나 빼준다. 이후 store에 지금 뽑은 숫자를 다시 저장 
        // 4. 뽑은 연산자가 +일 경우 store에 더해줌
        // 5. 마지막 숫자와 연산자를 뽑았을때 3번의 과정을 실행 후 반복문 종료
        int size = ops.size();
        int res = nums.poll();
        int store = 0;          // -이후에 나오는 숫자, + 연산자에 대해 계산하여 저장
        int exist_minus = 0;    // 식 내부에 -가 존재하지 않을 가능성 체크
        for(int i=0; i<size; i++) {
        	int tmp_num = nums.poll();
        	String tmp_op = ops.poll();
        	if("+".equals(tmp_op)) {
        		store += tmp_num;
        	}else {
        		if(exist_minus == 0) {
        			res += store;
        		}else {
        			res -= store;
        		}
        		store = tmp_num;
        		exist_minus = 1;
        	}
        	
        	if(i==size-1) {
        		if(exist_minus==0) {
        			res += store;
        		}else {
        			res -= store;
        		}
        	}
        }
        
        // 최종 결과 출력
        System.out.println(res);    
	}
}