import java.util.*;
import java.io.*;

// BJ #9095
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
       
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int n = Integer.parseInt(br.readLine());
        	int[] arr = new int[12];
        	arr[0] = 1;
        	int r1 = 0;
        	int r2 = 0;
        	int r3 = 0;
        	for(int j=1; j<n+1; j++) {
        		r1 = arr[j-1];
        		if(j-2>=0) {
        			r2 = arr[j-2];
        		}
        		if(j-3>=0) {
        			r3 = arr[j-3];
        		}
        		arr[j] = r1+r2+r3;
        	}
        	sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
	}
}