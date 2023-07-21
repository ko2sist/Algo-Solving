import java.io.*;
import java.util.*;

// BJ #2751
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[2000001];
		for (int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())+1000000]++;
		}
		
		for(int i=0; i<2000001; i++) {
			if(arr[i] != 0) {
				sb.append(i-1000000);
				sb.append("\n");
			}
		}
	
		System.out.println(sb);
	}
}