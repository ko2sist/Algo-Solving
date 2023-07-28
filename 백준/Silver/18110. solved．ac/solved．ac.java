import java.io.*;
import java.util.*;

// BJ #18110
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int sum = 0;
        int r = Math.round(0.15f*n);
        Arrays.sort(arr);
        
        for(int i=r; i<n-r; i++) {
        	sum+=arr[i];
        }

        System.out.println(Math.round(sum/(double)(n-2*r)));
    }
}