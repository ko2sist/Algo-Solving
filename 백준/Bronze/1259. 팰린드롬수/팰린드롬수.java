import java.io.*;
//import java.util.*;

// BJ #1259
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		loop1: while(true) {
			String s = br.readLine();
			if(Integer.parseInt(s) == 0) {
				break;
			}
			
			int tmp_len = s.length();
			int max = 0;
			if(tmp_len%2 == 0) {
				max = tmp_len/2;
			}else {
				max = (tmp_len-1)/2;
			}
			for(int i=0; i<max; i++) {
				if(s.charAt(i) != s.charAt(tmp_len-1-i)) {
					sb.append("no");
					sb.append("\n");
					continue loop1;
				} 
			}
			sb.append("yes");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}