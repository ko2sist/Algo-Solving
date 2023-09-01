import java.io.*;
import java.util.*;

// BJ #9252 - LCS 2
// Strategy: LCS
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        int[][] LCS = new int[len1+1][len2+1];
        
        for(int i=0; i<=len1; i++) {
        	for(int j=0; j<=len2; j++) {
        		if(i == 0 || j == 0) {
        			LCS[i][j] = 0;
        		}else if(s1.charAt(i-1) == s2.charAt(j-1)) {
        			LCS[i][j] = LCS[i-1][j-1] + 1;
        		}else {
        			LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        		}
        	}
        }
        
        Stack<Character> s = new Stack<>();
        int r = len1;
        int c = len2;
        while(true) {
        	if(LCS[r][c] == 0) break;
        	
        	if(LCS[r][c] == LCS[r-1][c]) {
        		r--;
        		continue;
        	}else if(LCS[r][c] == LCS[r][c-1]) {
        		c--;
        		continue;
        	}
        	s.add(s1.charAt(r-1));
        	r--;
        	c--;
        }
        
        sb.append(LCS[len1][len2]).append("\n");
        while(!s.isEmpty()) {
        	sb.append(s.pop());
        }
        
        System.out.println(sb);
    }
}