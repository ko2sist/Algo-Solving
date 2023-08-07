import java.util.*;
import java.io.*;

// BJ #2309 - 일곱 난쟁이
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int[] h = new int[9];
		for(int i=0; i<9; i++) {
			int tmp = Integer.parseInt(br.readLine());
			h[i] = tmp;
			sum += tmp;
		}
		
		
		int cal = sum - 100;
		int h1 = 0, h2 = 0;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(h[i]+h[j] == cal) {
					h1 = h[i];
					h2 = h[j];
					break;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<9; i++) {
			int tmp = h[i];
			if(!(tmp == h1 || tmp == h2)) {
				pq.add(tmp);
			}
		}

		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
			
		
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
