import java.io.*;
import java.util.*;

// BJ #2751
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer,Integer> map = new TreeMap<>();
		
		for (int i=0; i<N; i++) {
			map.put(Integer.parseInt(br.readLine()), 1);
		}
		
		for (int n: map.keySet()) {
			sb.append(n);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}