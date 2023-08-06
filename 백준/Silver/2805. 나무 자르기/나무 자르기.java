import java.util.*;
import java.io.*;

// BJ #2805
// 이분탐색 사용
public class Main {
	public static boolean check(int[] trees, long mid, int M) {
		long sum = 0;
		for(int i=0; i<trees.length; i++) {
			int tmp = trees[i]-(int)mid;
			if(tmp>=0) {
				sum += tmp;
			}
		}
		
		if(sum >= M) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 나무 길이 저장
        int[] trees = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	trees[i] = Integer.parseInt(st.nextToken());
        	if(trees[i] >= max) {
        		max = trees[i];
        	}
        }
        
        // 이분 탐색을 위한 시작, 끝점 설정
        long start = 0;
        long end = max;
        
        // 이분 탐색
        while(start+1 < end) {
        	long mid = (start+end)/2;
        	
        	if(check(trees, mid, M)) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }
        
        // 최종 결과 출력
        System.out.println(start);    
	}
}