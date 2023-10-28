import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			String res = "ON";
			for(int i=0; i<N; i++) {
				if((M & (1<<i)) != (1<<i)) {
					res = "OFF";
					break;
				}
			}
			
			sb.append("#"+t+" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
