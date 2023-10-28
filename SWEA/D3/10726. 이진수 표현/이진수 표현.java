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
			
			String res="";
			int bit = (1<<N)-1;
			if((M & bit) == bit) {
				res = "ON";
			}else {
				res = "OFF";
			}
			
			sb.append("#"+t+" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
