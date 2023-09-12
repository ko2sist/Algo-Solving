import java.util.*;
import java.io.*;

// BJ #2166 - 다각형의 면적
// Strategy: 신발끈 공식

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[][] point = new double[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double xi = Double.parseDouble(st.nextToken());
			double yi = Double.parseDouble(st.nextToken());
			
			point[i][0] = xi;
			point[i][1] = yi;
		}
		
		double res = 0;
		
		for(int i=0; i<N; i++) {
			if(i == 0) {
				res += point[i][0]*point[i+1][1];
				res -= point[i][0]*point[N-1][1];
			}else if(i == N-1){
				res += point[i][0]*point[0][1];
				res -= point[i][0]*point[i-1][1];
			}else {
				res += point[i][0]*point[i+1][1];
				res -= point[i][0]*point[i-1][1];
			}
		}
		
		System.out.printf("%.1f",Math.abs(res/2.0));
	}
}
