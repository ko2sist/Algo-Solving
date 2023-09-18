import java.util.*;
import java.io.*;

// SWEA #5658 - 보물상자 비밀번호
// Strategy: 

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	String s = br.readLine();
        	Set<Integer> set = new HashSet<>();
        	
        	for(int i=0; i<N/4; i++) {
        		for(int j=0; j<=N/4*3; j+=N/4) {
            		String hex_str = s.substring(j, j+N/4);
            		int n = Integer.parseInt(hex_str,16);
            		set.add(n);
            	}
        		
        		
        		s = s.charAt(s.length()-1) + s.substring(0,s.length()-1);
        		
        		
        	}
        	
        	List<Integer> list = new ArrayList<>(set);
        	Collections.sort(list,Collections.reverseOrder());

        	sb.append("#"+t).append(" ").append(list.get(K-1)).append("\n");
        }
        
        System.out.println(sb);
    }
}