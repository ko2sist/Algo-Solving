import java.io.*;
import java.util.*;

// BJ #1654
public class Main {
	public static boolean check(int[] lines, long mid, int N) {
		long sum = 0;
		for(int i=0; i<lines.length; i++) {
			sum += lines[i]/mid;
		}
		
		if(sum>=N) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // K: 현재 가지고 있는 랜선의 개수
        // N: 필요한 랜선의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // lines: 현재 가지고 있는 랜선의 길이 저장을 위한 배열
        // sum: 길이들의 합 저장
        int[] lines = new int[K];
        long sum = 0;
        for(int i=0; i<K; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	lines[i] = tmp;
        	sum += tmp;
        }
        
        // end: 이진탐색을 위한 끝점
        // start: 이진탐색을 위한 시작점
        long end = sum/N+1;
        long start = 1;

        // 이진탐색
        while(start + 1 < end) {
        	long mid = (start+end)/2;
        	
        	if(check(lines, mid, N)) {
        		start = mid;
        	}else {
        		end = mid;
        	}
        }
        	
        // 최종 결과 출력
        System.out.println(start);
    }
}
