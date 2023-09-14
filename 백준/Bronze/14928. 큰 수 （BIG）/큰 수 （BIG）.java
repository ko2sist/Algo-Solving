import java.util.*;
import java.io.*;

// BJ #
// Strategy:

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		int r = 0;
		for(int i=0; i<N.length(); i++) {
			r = (r*10 + N.charAt(i)-'0')%20000303;
		}
		
		System.out.println(r);
	}
}