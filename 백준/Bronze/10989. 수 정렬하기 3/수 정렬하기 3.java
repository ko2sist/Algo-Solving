import java.io.*;
import java.util.*;

// BJ #10989
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10000];
		for (int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine())-1]++;
		}
		
		for(int i=0; i<10000; i++) {
			if(arr[i] != 0) {
				for(int j=0; j<arr[i]; j++) {
					sb.append(i+1).append("\n");
				}
			}
		}
	
		System.out.println(sb);
	}
}