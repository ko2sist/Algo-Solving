import java.util.*;
import java.io.*;

// BJ #2579
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
       
        int N = Integer.parseInt(br.readLine());
        int[][] stairs = new int[N+1][3];
        for(int i=1; i<N+1; i++) {
        	stairs[i][0] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<N+1; i++) {
        	if (i==1) {
        		stairs[i][1] = stairs[i][0];
        		stairs[i][2] = stairs[i][0];
        	}else {
        		stairs[i][1] = stairs[i-1][2]+stairs[i][0];
        		if(stairs[i-2][1]>=stairs[i-2][2]) {
        			stairs[i][2] = stairs[i-2][1]+stairs[i][0];
        		}else {
        			stairs[i][2] = stairs[i-2][2]+stairs[i][0];
        		}
        	}
        }
        if(stairs[N][1]>=stairs[N][2]) {
        	System.out.println(stairs[N][1]);
        }else {
        	System.out.println(stairs[N][2]);
        }
	}
}