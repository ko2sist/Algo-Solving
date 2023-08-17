import java.io.*;
import java.util.*;

// BJ #15650 - N과 M(2)
// Strategy: 재귀
public class Main {
    public static StringBuilder NM2(int n, int m, int start) {
        StringBuilder sb = new StringBuilder();
        if(m == 1) {
        	for(int i=start; i<=n; i++) {
        		sb.append(i).append("\n");
        	}
        }else {
        	for(int i=start; i<=n-m+1; i++) {
        		String[] arr = NM2(n,m-1,i+1).toString().split("\n");
        		for(int j=0; j<arr.length; j++) {
        			sb.append(i).append(" ").append(arr[j]).append("\n");
        		}
        	}
        }
        return sb;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        // 최종 결과 출력
        System.out.print(NM2(N,M,1));
    }
}