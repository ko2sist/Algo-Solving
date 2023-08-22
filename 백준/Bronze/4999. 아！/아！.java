import java.util.*;
import java.io.*;

// BJ #4999 - 아!
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		String s1 = br.readLine();
		String s2 = br.readLine();
		
		if(s1.length() < s2.length()) {
			System.out.println("no");
		}else {
			System.out.println("go");
		}
		
//		System.out.println(sb);

	}
}
