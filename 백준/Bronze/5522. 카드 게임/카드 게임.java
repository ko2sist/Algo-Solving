import java.util.*;
import java.io.*;


// BJ #5522 -
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
		}
		
		System.out.println(sum);
	}
}
