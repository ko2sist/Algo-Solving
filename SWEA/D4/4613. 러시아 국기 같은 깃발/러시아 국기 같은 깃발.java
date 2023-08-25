import java.util.*;
import java.io.*;

// SWEA #4613 - 러시아 국기 같은 깃발
// Strategy:  
class Solution {	
	static Trio[] trio;	// trio: 국기의 각 행에 대한 Trio class를 저장하는 배열
	static int N, M;	// N,M: 국기의 크기
	
	// Trio: 국기의 각 행에 대해 행 전체가 해당 색이 되기 위해 칠해야 하는 칸수 저장하는 class
	public static class Trio{
		int red;
		int blue;
		int white;
		
		public Trio(int red, int blue, int white) {
			this.red = red;
			this.blue = blue;
			this.white = white;
		}
	}
	
	// cal(i,j): 국기를 다시 칠할 때 i번째 행에서 j번쨰 행까지를 파란색으로 칠한다고 했을때 
	//			새로 칠해야하는 칸의 개수 반환
	public static int cal(int i, int j) {
		int res = 0;
		
		for(int k=0; k<N; k++) {
			if(k < i) {			// 0행 ~ i-1행 까지는 흰색으로 칠함
				res += trio[k].white;
			
			}else if(k <= j) {	// i행 ~ j행 까지는 파란색으로 칠함
				res += trio[k].blue;
			
			}else {				// j+1 ~ N-1행 까지는 빨간색으로 칠함
				res += trio[k].red;
			}
		}
		
		return res;
	}
	
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	// min: 새로 칠해야 하는 칸의 최솟값
        	int min = Integer.MAX_VALUE;
        	
        	// N,M: 국기의 크기
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	// trio: 국기의 각 행에 대한 Trio class를 저장하는 배열
        	trio = new Trio[N];
        	
        	// 국기 각 행 순회하며 Trio 계산, 저장
        	for(int i=0; i<N; i++) {
        		int r = M;
        		int b = M;
        		int w = M;
        		String line = br.readLine();
        		for(int j=0; j<M; j++) {
        			char c = line.charAt(j);
        			if(c == 'R') r--;
        			else if(c == 'B') b--;
        			else w--;
        		}
        		trio[i] = new Trio(r, b, w);
        	}
        	
        	// 칠해야 하는 칸의 최솟값 구하기
        	for(int i=1; i<N-1; i++) {
        		for(int j=i; j<N-1; j++) {
        			int tmp = cal(i,j);
        			if(tmp < min) min = tmp;
        		}
        	}
        	
        	// 현재 테스트 케이스 결과 저장
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}
