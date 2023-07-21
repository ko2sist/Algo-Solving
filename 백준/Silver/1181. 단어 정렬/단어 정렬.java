import java.io.*;
import java.util.*;

// BJ #1018
public class Main {
	public static boolean compare(String s1, String s2) {
		
		
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n]; 
		int max_len = 0;
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			words[i] = tmp;
			if(tmp.length() >= max_len) {
				max_len = tmp.length();
			}
		}

		Map<String,Integer> outs = new TreeMap<>();
		for(int i=1; i<max_len+1; i++) {

			outs = new TreeMap<>();
			for(int j=0; j<n; j++) {
				if(words[j].length() == i) {
					outs.put(words[j], 1);
				}
			}
			for (String s: outs.keySet()) {
				System.out.println(s);
			}
		}
	}
}