import java.util.*;
import java.io.*;

// SWEA #1240 - 단순 2진 암호코드
// Strategy: 
public class Solution {
	public static int check(String code) {
		char[] c = code.toCharArray();
		if(c[1] == '0') {
			if(c[2] == '0') {
				if(c[4] == '0') {
					return 9;
				}else {
					return 0;
				}
			}else {
				if(c[3] == '0') {
					return 2;
				}else {
					return 1;
				}
			}
		}else {
			if(c[2] == '0') {
				if(c[3] == '0') {
					return 4;
				}else {
					return 6;
				}
			}else {
				if(c[3] == '0') {
					if(c[4]== '0') {
						return 5;
					}else {
						return 8;
					}
				}else {
					if(c[4]== '0') {
						return 7;
					}else {
						return 3;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[] code = new String[N];
			
			for(int i=0; i<N; i++) {
				code[i] = br.readLine();
			}

			loop: for(int i=0; i<N; i++) {
				String s = code[i];
				int f = 0;
				int b = 0;
				for(int j=0; j<M; j++) {
					if(s.charAt(j) == '0') {
						f++;
					}else {
						break;
					}
					
					if(f > M-53) continue loop;
				}
				
				for(int j=M-1; j>=0; j--) {
					if(s.charAt(j) == '0') {
						b++;
					}else {
						break;
					}
					
					if(f+b > M-53) continue loop;
				}

				String ccode = s.substring(f-(f+b-(M-56)), M-b);
				
				int[] nums = new int[9];
				int idx = 1;
				for(int j=0; j<56; j+=7) {
					String tmp = ccode.substring(j,j+7);
					nums[idx++] = check(tmp);
				}
				
				int check = 0;
				int res = 0;
				for(int j=1; j<=8; j++) {
					if(j%2 == 1) {
						check += nums[j]*3;
					}else {
						check += nums[j];
					}
					res += nums[j];
				}
				
				if(check % 10 == 0) {
					sb.append("#"+t).append(" ").append(res).append("\n");
				}else {
					sb.append("#"+t).append(" ").append(0).append("\n");
				}
				break;
			}
			
		}
		System.out.println(sb);
	}
}
