import java.util.*;
import java.io.*;

// BJ #13300 - 방 배정
// Strategy: DP(Dynamic Programming)
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[2][6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[gender][grade-1]++;
		}
		
		int res = 0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				res += (int)Math.ceil(students[i][j]/(double)2);
			}
		}
		System.out.println(res);
	}
}
