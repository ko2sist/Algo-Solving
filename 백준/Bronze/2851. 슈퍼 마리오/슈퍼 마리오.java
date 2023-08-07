import java.util.*;
import java.io.*;

// BJ #2851 - 슈퍼 마리오
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int prev_sum;
		for(int i=0; i<10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			prev_sum = sum;
			sum += tmp;
			if(sum >= 100) {
				if(sum-100 <= 100-prev_sum) {
					System.out.println(sum);
				}else {
					System.out.println(prev_sum);
				}
				break;
			}
		}
		
		if(sum < 100) {
			System.out.println(sum);
		}
	}
}
