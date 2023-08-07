import java.util.*;
import java.io.*;

// BJ #2999 - 비밀 이메일
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		int N = s.length();
		int max = (int)Math.sqrt(N);
		int R = 0;
		int C = 0;
		for(int i=max; i>0; i--) {
			if(N%i == 0) {
				R = i;
				C = N/i;
				break;
			}
		}
		
		char[][] c = new char[R][C];
		int idx = 0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				c[j][i] = s.charAt(idx++);
			}
		}
		
		String res = "";
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				res += c[i][j];
			}
		}
		
		System.out.println(res);
	}
}
