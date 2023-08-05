import java.util.*;
import java.io.*;

// BJ #11659
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int k=1; k<N+1; k++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr[k] = arr[k-1] + tmp;
        }
        for(int k=0; k<M; k++) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());    	
        	sb.append(arr[j]-arr[i-1]).append("\n");
        }
        System.out.println(sb);
	}
}