import java.io.*;
import java.util.*;

// BJ #9251 - LCS
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
        
        // 최종 결과 출력
        System.out.print(LCS[len1][len2]);
    }
}