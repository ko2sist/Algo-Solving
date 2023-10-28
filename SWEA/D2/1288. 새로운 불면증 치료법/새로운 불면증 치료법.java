import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, end=(1<<10)-1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			int tmp = N;
			int visited = 0;
			
			while(visited != end) {
				char[] arr = String.valueOf(tmp).toCharArray();
				for(char c : arr) {
					int n = c-'0';
					visited = visited | (1<<n);
				}
				
				tmp += N;
			}
			
			
			sb.append("#"+t+" ").append(tmp-N).append("\n");
		}
		System.out.println(sb);
	}
}
