import java.io.*;
import java.util.*;

// BJ #5430 - AC
// Strategy: 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        loop: for(int t=0; t<T; t++) {
        	String p = br.readLine();
        	int num_R = 0;
        	int num_Df = 0;
        	int num_Db = 0;
        	for(int i=0; i<p.length(); i++) {
        		if(p.charAt(i) == 'R') {
        			num_R++;
        		}else {
        			if(num_R % 2 == 0) {
        				num_Df++;
        			}else {
        				num_Db++;
        			}
        		}
        	}

        	int n = Integer.parseInt(br.readLine());
        	
        	String s_arr = br.readLine();
        	int[] arr = new int[n];
        	int idx = 0;

        	StringBuilder tmp = new StringBuilder();
        	
        	for(int i=0; i<s_arr.length(); i++) {
        		char tmp_c = s_arr.charAt(i);
        		
        		if(tmp_c >= 48 && tmp_c <= 57) {
        			tmp.append(tmp_c);
        		}else {
        			if(tmp.length() != 0) {
        				arr[idx++] = Integer.parseInt(tmp.toString());
        				tmp.setLength(0);
        			}
        		}
        	}
        	
        	// 숫자 지우기
        	if(num_Df + num_Db > n) {
        		sb.append("error").append("\n");
        		continue loop;
        	}
        	int f = 0;
        	int b = arr.length-1;
        	for(int i=0; i<num_Df; i++) {
        		f++;
        	}
        	for(int i=0; i<num_Db; i++) {
        		b--;
        	}
        	
        	// 에러가 없을경우 출력
        	if(f>b) {
        		sb.append("[]\n");
        	}else {
        		if(num_R % 2 == 0) {
    				sb.append("[");
    				for(int i = f; i <= b; i++) {
    					sb.append(arr[i]).append(",");
    				}
    				sb.deleteCharAt(sb.length()-1);
    				sb.append("]").append("\n");
    			}else {
    				sb.append("[");
    				for(int i = b; i >= f; i--) {
    					sb.append(arr[i]).append(",");
    				}
    				sb.deleteCharAt(sb.length()-1);
    				sb.append("]").append("\n");
    			}
        	}
        	
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}