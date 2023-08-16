import java.io.*;
import java.util.*;

// BJ #20529 - 가장 가까운 세 사람의 심리적 거리
// Strategy: 비둘기집의 원리
public class Main {
	public static int distance(String s1, String s2) {
		int res = 0;
		for(int i=0; i<4; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				res++;
			}
		}
		return res;
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	if(N >= 33) {		// 적어도 1가지 성격은 3명 이상
        		sb.append(0).append("\n");
        	}else {
        		int min = 24;
        		String[] arr = new String[N];
        		for(int i=0; i<N; i++) {
            		arr[i] = st.nextToken();
            	}
        		
        		for(int i=0; i<N-2; i++) {
        			for(int j=i+1; j<N-1; j++) {
        				for(int k=j+1; k<N; k++) {
        					int sum = distance(arr[i],arr[j]) + distance(arr[i],arr[k]) + distance(arr[j],arr[k]);
        					if(sum <= min) {
        						min = sum;
        					}
        				}
        			}
        		}
        		sb.append(min).append("\n");
        	}
        }
          
        // 최종 결과 출력
        System.out.println(sb);
    }
}