import java.io.*;
import java.util.*;

// BJ #2751
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			map.put(Integer.parseInt(br.readLine()), 1);
		}
		List<Integer> keylist = new ArrayList<>(map.keySet());
		keylist.sort((s1,s2) -> s1.compareTo(s2));
		
		for (int n: keylist) {
			sb.append(n);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}